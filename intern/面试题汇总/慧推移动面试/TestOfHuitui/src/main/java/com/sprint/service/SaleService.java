package com.sprint.service;
import java.text.*;
import java.util.*;
import java.io.*;

import jxl.Workbook;
import jxl.Sheet;
import jxl.*;
import com.sprint.models.domain.Sale;
import com.sprint.models.dao.SaleDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class SaleService {
	
	@Autowired
	private SaleDao saleDao;

	public List<Sale> findAll() {
		return saleDao.findAll();
	}
	public List<Sale> getAllByExcel(String file) {
		List<Sale> list = new ArrayList<Sale>();
		try {
			Workbook wb = Workbook.getWorkbook(new File(file));
			Sheet rt = wb.getSheet("Sale");
			int cols =  rt.getColumns();
			int rows = rt.getRows();

			System.out.println("cols: " + cols + "rows: " + rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					Cell cell = rt.getCell(j++, i);
					Date sd;
					String sDate = null; 
					if (cell.getType() == CellType.DATE) {
						DateCell dc = (DateCell)cell;
						sd = dc.getDate();
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						sDate = format.format(sd);
					} else {
						continue;
					}
					String userId= rt.getCell(j++, i).getContents();
					String productId = rt.getCell(j++, i).getContents();
					String salePrice = rt.getCell(j++, i).getContents();
					String saleNumber = rt.getCell(j++, i).getContents();
					int uId = Integer.parseInt(userId);
					int pId = Integer.parseInt(productId);
					double sPrice = Double.parseDouble(salePrice);
					double sNumber = Double.parseDouble(saleNumber);
					saleDao.insertSale(new Sale(uId, pId, sDate, sPrice, sNumber));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

package com.sprint.service;

import java.util.*;
import java.io.*;
import com.sprint.models.domain.*;
import com.sprint.models.dao.*;

import jxl.Workbook;
import jxl.Sheet;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public List<Product> findAll() {
		return productDao.findAll();
	}
	public List<Product> getAllByExcel(String file) {
		List<Product> list = new ArrayList<Product>();
		try {
			Workbook wb = Workbook.getWorkbook(new File(file));
			Sheet rt = wb.getSheet("Product");
			int cols =  rt.getColumns();
			int rows = rt.getRows();

			System.out.println("cols: " + cols + "rows: " + rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					String pId = rt.getCell(j++, i).getContents(); 
					String pName = rt.getCell(j++, i).getContents();
					String pType = rt.getCell(j++, i).getContents();
					String pPrice = rt.getCell(j++, i).getContents();
					String pUnit = rt.getCell(j++, i).getContents();
					int id = Integer.parseInt(pId);
					double price = Double.parseDouble(pPrice);
					productDao.insertProduct(new Product(id, pName, pType, price, pUnit));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

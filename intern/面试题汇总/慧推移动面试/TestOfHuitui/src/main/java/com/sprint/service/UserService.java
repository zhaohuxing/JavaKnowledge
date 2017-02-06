package com.sprint.service;
import java.text.*;
import java.util.*;
import java.io.*;

import jxl.Workbook;
import jxl.Sheet;
import jxl.CellType;
import jxl.Cell;
import jxl.DateCell;

import com.sprint.models.domain.*;
import com.sprint.models.dao.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public List<User> getAllByExcel(String file) {
		List<User> list = new ArrayList<User>();
		try {
			Workbook wb = Workbook.getWorkbook(new File(file));
			Sheet rt = wb.getSheet("User");
			int cols =  rt.getColumns();
			int rows = rt.getRows();

			System.out.println("cols: " + cols + "rows: " + rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					String idStr = rt.getCell(j++, i).getContents(); 
					String name = rt.getCell(j++, i).getContents();
					String address = rt.getCell(j++, i).getContents();
					Cell cell = rt.getCell(j++, i);
					Date birthD;
					String birth;
					if (cell.getType() == CellType.DATE) {
						DateCell dc = (DateCell)cell;
						birthD = dc.getDate();
						System.out.println(birthD);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						birth = format.format(birthD);
					} else {
						continue;
					}
					String sex = rt.getCell(j++, i).getContents();
					int id = Integer.parseInt(idStr);
					System.out.println(birth);
					userDao.insertUser(new User(id, name, address, birth, sex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

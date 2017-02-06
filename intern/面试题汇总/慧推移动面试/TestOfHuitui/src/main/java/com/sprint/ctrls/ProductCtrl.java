package com.sprint.ctrls;

import java.util.*;
import com.sprint.service.*;
import com.sprint.models.domain.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/product")
public class ProductCtrl {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public List<Product> findAll() {
		return productService.findAll(); 
	}
	

}

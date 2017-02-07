package com.sprint.ctrls;

import java.util.*;
import com.sprint.service.*;
import com.sprint.models.domain.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class ProductCtrl {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/findProduct")
	public String findProduct(Model model) {
		model.addAttribute("productList", productService.findAll());
		return "product";
	}

}

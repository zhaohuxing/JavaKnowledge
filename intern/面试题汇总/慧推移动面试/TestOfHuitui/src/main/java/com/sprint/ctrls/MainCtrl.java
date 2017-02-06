package com.sprint.ctrls;
import com.sprint.service.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class MainCtrl {

	@RequestMapping("/")
	public String index() {
		return "index";
	} 

	@Autowired
	private UserService userService;
	@RequestMapping("/findUser")
	public String findUser(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "main";
	}

	@Autowired
	private ProductService productService;

	@RequestMapping("/findProduct")
	public String findProduct(Model model) {
		model.addAttribute("productList", productService.findAll());
		return "product";
	}

	@Autowired
	private SaleService saleService;

	@RequestMapping("/findSale")
	public String findSale(Model model) {
		model.addAttribute("saleList", saleService.findAll());
		return "sale";
	}
}

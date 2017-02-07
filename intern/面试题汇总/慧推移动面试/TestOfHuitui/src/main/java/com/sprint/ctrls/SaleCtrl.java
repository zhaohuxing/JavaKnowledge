package com.sprint.ctrls;
import java.util.*;
import com.sprint.service.*;
import com.sprint.models.domain.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SaleCtrl {

	@Autowired
	private SaleService saleService;

	@RequestMapping("/findSale")
	public String findSale(Model model) {
		model.addAttribute("saleList", saleService.findAll());
		return "sale";
	}

	@RequestMapping("/findSaleByUser")
	public String findUserByKey(@RequestParam("userId") int userId, Model model) {
		model.addAttribute("saleList", saleService.findSaleByUser(userId));
		return "findSaleByUser";
	}

	@RequestMapping("/findSaleByProduct")
	public String findSaleByProduct(@RequestParam("productId") int productId, Model model) {
		model.addAttribute("saleList", saleService.findSaleByProduct(productId));
		return "findSaleByProduct";
	} 
}

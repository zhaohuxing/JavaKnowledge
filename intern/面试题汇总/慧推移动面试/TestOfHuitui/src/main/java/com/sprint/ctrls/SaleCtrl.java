package com.sprint.ctrls;
import java.util.*;
import com.sprint.service.*;
import com.sprint.models.domain.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/sale")
public class SaleCtrl {
	
	@Autowired
	private SaleService saleService;

	@RequestMapping("/")
	public List<Sale> findAll() {
		return saleService.findAll();
	}
}

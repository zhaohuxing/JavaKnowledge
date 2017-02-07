package com.sprint.ctrls;
import com.sprint.service.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class MainCtrl {

	@RequestMapping("/")
	public String index() {
		return "index";
	} 

}

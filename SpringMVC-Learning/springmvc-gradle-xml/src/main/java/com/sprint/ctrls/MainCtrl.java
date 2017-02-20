package com.sprint.ctrls;

import java.text.*;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class MainCtrl {
	
	@RequestMapping("/")
	public String main(Model model) {
		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
		model.addAttribute("serverTime", currentTime);	
		return "main";
	}
}

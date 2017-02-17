package com.sprint.ctrls;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserCtrl {
	
	@RequestMapping("/user")
	public String getString() {
		return "ok fine";
	}
}

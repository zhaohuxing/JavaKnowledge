package com.sprint.ctrls;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sprint.service.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class UserCtrl {

//	@Autowired
//	UserService us;
//	好好看看spring
	@RequestMapping("/user")
	public String getString() {
		UserService us = new UserService();
		return us.test();
	}
}

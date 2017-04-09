package com.sprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}

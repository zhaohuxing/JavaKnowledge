package com.sprint.controller;

import com.sprint.dao.model.User;
import com.sprint.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/validate/{token}", method = RequestMethod.GET)
	public String emailConfirm(@PathVariable("token") String token, Model model) {
		User user = userService.completeSignUp(token);
		if (user != null) {
			model.addAttribute("email", user.getEmail());
			model.addAttribute("result", "注册成功，赶快登录体验吧！");
		} else {
			model.addAttribute("result", "链接已失效, 请重新注册！");
		}
		return "login";
	}
}

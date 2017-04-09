package com.sprint.api;

import com.sprint.dao.model.User;
import com.sprint.dao.service.UserService;
import com.sprint.dto.SimpleResponse;
import com.sprint.util.CheckUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserApi {
	
	@Autowired
	private UserService service;

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public SimpleResponse signUp(HttpServletRequest request) {
		User user = createUser(request);
		SimpleResponse response = checkSignUpRequest(user);
		if (response.getCode() == 100) {
			if (!service.signUp(user)) {
				response.setCode(200);
				response.setMessage("此邮箱已注册，请勿重复注册！");
				return response;
			} else {
				response.setMessage("注册激活邮件已发送至您的邮箱，请在12小时内激活完成注册！");
				return response;
			}
		}
		return response;
	}
	
	private User createUser(HttpServletRequest request) {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setNickname(request.getParameter("nickname"));
		return user;
	}

	private SimpleResponse checkSignUpRequest(User user) {
		SimpleResponse response = new SimpleResponse();
		String email = user.getEmail();
		if (!CheckUtil.checkEmail(email)) {
			response.setCode(200);
			response.setMessage("邮箱格式不合格");
			return response;
		}

		String password = user.getPassword();
		if (!CheckUtil.checkPassword(password)) {
			response.setCode(200);
			response.setMessage("密码长度必须为8-16位，且必须包含数字和字母");
			return response;
		}

		String nickname = user.getNickname();
		if (!CheckUtil.checkNickname(nickname)) {
			response.setCode(200);
			response.setMessage("昵称长度不合法");
			return response;
		}
		response.setCode(100);
		return response;
	}
}

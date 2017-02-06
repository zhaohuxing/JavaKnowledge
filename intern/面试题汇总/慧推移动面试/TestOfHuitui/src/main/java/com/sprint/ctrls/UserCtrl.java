package com.sprint.ctrls;

import java.util.*;
import java.io.*;
import com.sprint.service.UserService;
import com.sprint.models.domain.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
public class UserCtrl {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public List<User> findAll() {
		return userService.findAll();	
	}

}

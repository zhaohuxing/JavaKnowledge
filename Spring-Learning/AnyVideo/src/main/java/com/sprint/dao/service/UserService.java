package com.sprint.dao.service;

import com.sprint.dao.model.User;
import com.sprint.dao.mapper.UserMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service
 * Created by sprint 2017/04/06
 */

@Service
@Log4j
public class UserService {
	
	@Autowired
	private UserMapper mapper;

	public User getByEmail(String email) {
		return mapper.selectByEmail(email);
	}
}

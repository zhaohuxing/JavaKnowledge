package com.sprint.models.dao;

import java.util.*;
import com.sprint.models.domain.*;
public interface UserDao {
	List<User> findAll();
	void insertUser(User user);
}

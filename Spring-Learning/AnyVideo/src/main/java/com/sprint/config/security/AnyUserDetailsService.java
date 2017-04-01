package com.sprint.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service; 

/**
 * 自定义UserDetailsService
 * Create by sprint on 2017/04/01.
 */
@Service
class AnyUserDetailsService extends UserDetailsService{
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
									throws UsernameNotFoundException {
			
	}


}

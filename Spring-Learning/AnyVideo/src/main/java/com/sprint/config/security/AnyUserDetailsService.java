package com.sprint.config.security;

import com.sprint.dao.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service; 

/**
 * 自定义UserDetailsService
 * Create by sprint on 2017/04/01.
 */
@Service
class AnyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
									throws UsernameNotFoundException {
		com.sprint.dao.model.User user = userService.getByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(username, user.getPassword(), authorities);
	}
}

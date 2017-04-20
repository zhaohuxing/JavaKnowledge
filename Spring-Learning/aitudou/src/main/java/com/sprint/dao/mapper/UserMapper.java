package com.sprint.dao.mapper;

import com.sprint.dao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;



@Mapper
public interface UserMapper {
	
	@Select("select * from user where email = #{email}")
	User selectByEmail(@Param("email") String email);

	@Insert("insert into user(email, password, nickname) values(#{email}, #{password}, #{nickname})")
	int insert(User user);
}

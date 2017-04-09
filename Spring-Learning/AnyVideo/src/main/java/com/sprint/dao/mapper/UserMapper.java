package com.sprint.dao.mapper;

import com.sprint.dao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface UserMapper {
	
	@Select("select * from user where email = #{email}")
	User selectByEmail(@Param("email") String email);
}

package com.sprint.dao.mapper;

import com.sprint.dao.model.Category;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface CategoryMapper {

	@Select("select * from category where user_id = #{userId}")
	List<Category> selectByUserId(@Param("userId") Long userId); 
}

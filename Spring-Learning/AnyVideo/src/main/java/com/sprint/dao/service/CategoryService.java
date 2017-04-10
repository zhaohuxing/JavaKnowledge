package com.sprint.dao.service;

import com.sprint.dao.model.Category;
import com.sprint.dao.mapper.CategoryMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
@Log4j
public class CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;

	public List<Category> getByUserId(Long userId) {
		List<Category> categories = categoryMapper.selectByUserId(userId);
		if (categories == null) {
			return new ArrayList<>();
		}
		return categories;
	}


}

package com.sprint.models.dao;
import java.util.List;
import com.sprint.models.domain.*;
public interface ProductDao {
	void insertProduct(Product product);
	List<Product> findAll();
}

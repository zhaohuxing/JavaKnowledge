package com.sprint.models.dao;
import java.util.*;
import com.sprint.models.domain.Sale;
public interface SaleDao {
	void insertSale(Sale sale);
	List<Sale> findAll();
}

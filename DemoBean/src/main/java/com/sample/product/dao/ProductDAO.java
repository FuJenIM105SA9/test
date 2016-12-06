package com.sample.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.product.entity.Product;
import com.sample.product.entity.PurchaseOrder;

public interface ProductDAO {
	
	public List<Product> getList();
	
	public List<Product> getList2a();
	
	public List<Product> getList2b();
	
	public List<Product> getList2c();
	
	public List<Product> getList2d();
	
	public List<Product> getList2e();
	
	public void insert(Product aProduct);

	public Product get(Product product);
	
	public void update(Product aProduct);
	
	public void delete(long id);

	public int count();
	
	public List <PurchaseOrder> getpList();
	
	
	public int sellProduct(List<Long> pList) throws SQLException ;
	
	public List<Product> getReorderList();
		// TODO Auto-generated method stu

	public List<Product> getList3();
	
	
}//ProductDAO


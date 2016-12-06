package com.sample.product.dao;

import java.util.List;

import com.sample.product.entity.Product;

public interface ProductDAO2 {
	
	public List<Product> getList();
	public void add(Product aProduct);

	public Product get(long id);

	public int count();

}//ProductDAO


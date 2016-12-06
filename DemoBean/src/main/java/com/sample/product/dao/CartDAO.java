package com.sample.product.dao;

import java.util.ArrayList;
import java.util.List;

import com.sample.product.entity.Product;

//using List<Product> to store product
public class CartDAO implements ProductDAO2 {
	private List<Product> shoppingList = new ArrayList<Product>();
	
	public CartDAO(){
		
	}
	public void add(Product aProduct){
		aProduct.setId(shoppingList.size());
		shoppingList.add(aProduct);
	}
	public Product get(long id){
		return shoppingList.get((int)id); 
	}
	
	public int count(){
		return shoppingList.size();
	}


	@Override
	public List<Product> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
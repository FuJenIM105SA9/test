package com.sample.product.entity;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)

public class shoppingcart implements java.io.Serializable{
	private static final long serialVersionUID = 8772944132506476198L;
	private List<Product> productList=new ArrayList<Product>();
	
	public List<Product>getCart(){
		return productList;
	}
	public void add(Product aProduct){
		productList.add(aProduct);
	}
	public int count(){
		return productList.size();
	}
	public void cleanup(){
		productList=new ArrayList<Product>();
	}
    }



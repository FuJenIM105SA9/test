package com.sample.product.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
//@Component
//@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class account implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8772944132506476198L;
	private String username;
	private String password;

	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	
}
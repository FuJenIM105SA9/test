package com.sample.product.controller;

//import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.product.entity.Product;
import com.sample.product.entity.shoppingcart;
import com.sample.product.dao.ProductDAO;
import com.sample.product.dao.ProductDAODB;

/**
 * Handles requests for the application home page.
 */
@Controller
public class sellcontroller {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		return getProductList();
	}//getProductList
	*/
	//list all products	

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public ModelAndView checkout(){
		ModelAndView model = new ModelAndView("shoppingcart");
		shoppingcart shoppingcart = (shoppingcart)context.getBean("shoppingcart");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> pList =  shoppingcart.getCart();
		List<Long> pList2 = new ArrayList<Long>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getId());
			System.out.println(pList2);
		}
		int result = 0;
		try {
			result = productDAO.sellProduct(pList2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			shoppingcart.cleanup();
		}
		return model;
	}
	
	
}//ProductController

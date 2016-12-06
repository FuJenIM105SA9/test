package com.sample.product.controller;

//import java.util.ArrayList;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		return getProductList();
	}//getProductList
	*/
	//list all products	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProductList(){
		ModelAndView model = new ModelAndView("product");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/product2", method = RequestMethod.GET)
	public ModelAndView getProductList2(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list=dao.getList();
		model.addObject(list);
		return model;
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu() {
		return "menu";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(){
		ModelAndView model = new ModelAndView("product2");
		
		return model;
	}//getProductList
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchpage(){
		ModelAndView model = new ModelAndView("redirect:/product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList3();
		
		model.addObject(list);
		return model;
	}
	
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public ModelAndView getProductList2a(){
		ModelAndView model = new ModelAndView("product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList2a();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/opera", method = RequestMethod.GET)
	public ModelAndView getProductList2b(){
		ModelAndView model = new ModelAndView("product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList2b();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/cartoon", method = RequestMethod.GET)
	public ModelAndView getProductList2c(){
		ModelAndView model = new ModelAndView("product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList2c();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/art", method = RequestMethod.GET)
	public ModelAndView getProductList2d(){
		ModelAndView model = new ModelAndView("product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList2d();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/music", method = RequestMethod.GET)
	public ModelAndView getProductList2e(){
		ModelAndView model = new ModelAndView("product2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList2e();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProductPage(){
		ModelAndView model = new ModelAndView("insertProduct");
		return model;
	}//insertProductPage
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");	
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product.setId(dao.count());
		dao.insert(product);
		return model;
	}//insertProduct
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public ModelAndView updateProductPage(@ModelAttribute Product product){
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		ModelAndView model = new ModelAndView("updateProduct");
		product=dao.get(product);
			model.addObject("product",product);
			return model;
	}//updateProductPage
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");	
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		//product.setId(dao.count());
		dao.update(product);
	
		return model;
		
	}//updateProduct
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProductPage(@ModelAttribute Product product, long id){
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		ModelAndView model = new ModelAndView("redirect:/product");
		dao.delete(id);
		return model;
	}//deleteProductPage
	
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ModelAndView shoppingcartpage(@ModelAttribute Product product){
	   long pid=product.getId();
	   String cat=product.getCategory();
	  ModelAndView model = new ModelAndView("redirect:/product2");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product = productDAO.get(product);
      shoppingcart shoppingcart=(shoppingcart)context.getBean("shoppingcart");
			shoppingcart.add(product);
			String movie = null;
			movie=movie;
			List<Product> list =null;
			String cartoon = null;
			cartoon=cartoon;
			String art = null;
			art=art;
			String music=null;
			music=music;
			String opera = null;
			opera=opera;
			if(cat==movie){ list = dao.getList2a();}
			else if(cat==opera){list = dao.getList2b();}
			else if(cat==cartoon){list = dao.getList2c();}
			else if(cat==art){list = dao.getList2d();}
			else if(cat==music){list = dao.getList2e();}
			else list=dao.getList();
			model.addObject(list);
			return model;
	}
	@RequestMapping(value = "/showcart", method = RequestMethod.GET)
	public ModelAndView showcartpage(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("shoppingcart");
      shoppingcart shoppingcart=(shoppingcart)context.getBean("shoppingcart");
			List<Product>content=shoppingcart.getCart();
			model.addObject("shoppingcart",content);
			return model;
	}
	
	@RequestMapping(value = "/categorize", method = RequestMethod.GET)
	public ModelAndView categorize(@ModelAttribute Product product, String category){
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		ModelAndView model = new ModelAndView("redirect:/product2");
		
		return model;
	}
	
	
}//ProductController

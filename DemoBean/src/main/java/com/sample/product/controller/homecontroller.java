package com.sample.product.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.product.entity.account;

@Controller
public class homecontroller {
	//@Autowired private Account account_session;
	ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "menu";
	}
	
	
	
	
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public ModelAndView  home2() {
		ModelAndView model = new ModelAndView("home2");
		account account_session = (account)context.getBean("account");
		//System.out.println("session in home2:"+account_session.getUsername());

		model.addObject("account",account_session);
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "home";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute account account) {
		ModelAndView model = new ModelAndView("home");	
		account account_session = (account)context.getBean("account");
		if ("sa".equals(account.getUsername()) && "ilovesa".equals(account.getPassword())){
			account_session.setUsername(account.getUsername());
			//DO NOT use the following: 
			//account_session = account;
			model = new ModelAndView("redirect:/product");
			model.addObject("message", "登入成功");
			
		}
		else{
			account_session.setUsername("");
			model = new ModelAndView("redirect:/menu");
			model.addObject("message", "登入失敗");
			
		}	
		//System.out.println("model:"+account.getUsername());
		//System.out.println("session:"+account_session.getUsername());
		
		return model;
	}

	
	
}

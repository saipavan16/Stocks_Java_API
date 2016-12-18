package com.suddenlyjune.financialinvestment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suddenlyjune.financialinvestment.dao.User;
import com.suddenlyjune.financialinvestment.service.UsersService;

@Controller
public class UserController {
	private UsersService usersService;
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	@RequestMapping("/createuser")
	public String createOffers(Model model){
		model.addAttribute("user", new User());
		return "createuser";
	}
	
	@RequestMapping(value="/docreate", method = RequestMethod.POST)
	public String doCreate(@Valid User user, BindingResult result){
		
		if (result.hasErrors()) {
	return "createuser";
		} 
		usersService.create(user);
		return "usercreated";
	}
	
		
}

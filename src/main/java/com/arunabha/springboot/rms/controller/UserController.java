package com.arunabha.springboot.rms.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arunabha.springboot.rms.model.User;
import com.arunabha.springboot.rms.repository.UserRepository;
import com.arunabha.springboot.rms.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	public UserService userservice;
	
	@Autowired
	public UserRepository userrepository;
	
	@RequestMapping(method=RequestMethod.POST,value="/user-register")
	public void RegisterUser(@RequestBody User user) {
		userservice.sendUserDetailsforRegistration(user);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/user-login")
	public void LoginUser(@RequestBody User user) {
		userservice.sendUserDetailsforLogin(user);
	}
	
/*	@RequestMapping(method=RequestMethod.POST,value="/userregister")
	public void AddUser(@RequestBody User user) {
		userservice.AddUserDetails(user);
	}
	
	
	@RequestMapping("/userdetails")
	public List<User> GetAllUsers(){
		
		return (userservice.UserDetails());
	}
	
*/	

}

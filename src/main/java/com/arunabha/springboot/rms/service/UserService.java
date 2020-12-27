package com.arunabha.springboot.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunabha.springboot.rms.model.User;
import com.arunabha.springboot.rms.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	public UserRepository userrepository;
	
	List<User> list = new ArrayList<>();
	
	public void sendUserDetailsforRegistration(User user) {
		int return_code=userrepository.CheckUserExistenceinDB(user);
		if ( return_code == 1)
			System.out.println("Username Already Exists");
		else
		userrepository.RegisterUserinDB(user);
	}

	public void sendUserDetailsforLogin(User user) {
		userrepository.VerifyUserCredinDB(user);
		
	}



/*	public void AddUserDetails(User user) {
		list.add(user);
	}


	public List<User> UserDetails(){
		return list;
	}
*/	
}
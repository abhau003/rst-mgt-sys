package com.arunabha.springboot.rms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arunabha.springboot.rms.model.User;

@Repository
public class UserRepository {
	
	@Autowired
     JdbcTemplate jdbctemplate;
	
	public UserRepository(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	public void RegisterUserinDB(User user){
	    String REGISTER_USER_SQL="insert into rms_springdb.user(username,first_name,last_name,email_id,password) values(?,?,?,?,?)";
		jdbctemplate.update(REGISTER_USER_SQL, user.getUsername(),user.getFirst_name(),user.getLast_name(),user.getEmail_id(),user.getPassword() );
	}

	public int CheckUserExistenceinDB(User user) {
		String SEARCH_USER_SQL="select count(*) from rms_springdb.user where username = ?";
		int count = jdbctemplate.queryForObject(SEARCH_USER_SQL,Integer.class,user.getUsername());
		return count;
		
	}

	public void VerifyUserCredinDB(User user) {
		int usr_pswd_cnt=0;
		String USERNAME_VERIFY_USER_SQL="select count(*) from rms_springdb.user where username = ?";
		int usr_cnt = jdbctemplate.queryForObject(USERNAME_VERIFY_USER_SQL,Integer.class,user.getUsername());
		if (usr_cnt == 1) {
			String PASSWORD_VERIFY_USER_SQL="select count(*) from rms_springdb.user where username = ? and password = ?";
			usr_pswd_cnt = jdbctemplate.queryForObject(PASSWORD_VERIFY_USER_SQL,Integer.class,user.getUsername(),user.getPassword());
		}
		else
			System.out.println("You are not Registered, please register to Continue !!!");
		
		if (usr_pswd_cnt == 1)
			System.out.println("You are Logged-In, please continue to Explore");
	}

}

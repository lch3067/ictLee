package main.controller;

import java.sql.Date;
import java.sql.Timestamp;

import main.dto.UserDto;
import main.service.UserService;
import main.service.Implements.UserServiceImpl;

public class UserController {

	UserService login = new UserServiceImpl();
	
	public boolean Login(String id, String pwd) {
		
		boolean authentication = login.Login(id, pwd);
		if(authentication) {			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Join(UserDto userdto) {
		
		boolean authentication = login.Join(userdto);
		if(authentication) {			
			return true;
		} else {
			return false;
		}
		
	}
	
}

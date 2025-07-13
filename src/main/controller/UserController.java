package main.controller;

import java.sql.Date;
import java.sql.Timestamp;

import main.dto.LoginResultDto;
import main.dto.UserDto;
import main.service.UserService;
import main.service.Implements.UserServiceImpl;

public class UserController {

	UserService login = new UserServiceImpl();
	
	public LoginResultDto Login(String id, String pwd) {
		
		LoginResultDto authentication =  login.Login(id, pwd);
		if(authentication.isSuccess()) {
			return new LoginResultDto(authentication.isSuccess(), authentication.getRole(), authentication.getName());
		} else {
			return new LoginResultDto(authentication.isSuccess(), authentication.getRole(), authentication.getName());
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

package main.service;

import main.dto.LoginResultDto;
import main.dto.UserDto;

public interface UserService {
	
	public LoginResultDto Login(String id, String pwd);
	
	public boolean Join(UserDto userdto);
	
	public boolean userIdDuplicateCheck(String userId);

}

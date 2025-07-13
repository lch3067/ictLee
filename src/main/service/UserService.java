package main.service;

import main.dto.UserDto;

public interface UserService {
	
	public boolean Login(String id, String pwd);
	
	public boolean Join(UserDto userdto);

}

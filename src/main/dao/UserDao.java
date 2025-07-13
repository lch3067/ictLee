package main.dao;

import main.dto.UserDto;

public interface UserDao {
	
	public boolean Login(String id, String pwd);
	
	public boolean Join(UserDto userdto);

}

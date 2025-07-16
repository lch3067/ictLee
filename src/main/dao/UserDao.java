package main.dao;

import main.dto.LoginResultDto;
import main.dto.UserDto;

public interface UserDao {
	
	public LoginResultDto Login(String id, String pwd);
	
	public boolean Join(UserDto userdto);

	public boolean userIdDuplicateCheck(String userId);
}

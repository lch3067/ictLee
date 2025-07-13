package main.service.Implements;

import main.dao.UserDao;
import main.dao.Implements.UserDaoImpl;
import main.dto.UserDto;
import main.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao logindao = UserDaoImpl.getInstance();
	
	@Override
	public boolean Login(String id, String pwd) {
		boolean authentication =  logindao.Login(id, pwd);
		if(authentication) {
			return true;
		} else {
			return false;
		}	
	}

	@Override
	public boolean Join(UserDto userdto) {
		boolean authentication =  logindao.Join(userdto);
		if(authentication) {
			return true;
		} else {
			return false;
		}	
	}

}

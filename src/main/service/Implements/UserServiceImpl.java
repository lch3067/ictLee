package main.service.Implements;

import main.dao.UserDao;
import main.dao.Implements.UserDaoImpl;
import main.dto.LoginResultDto;
import main.dto.UserDto;
import main.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao loginDao = UserDaoImpl.getInstance();
	
	@Override
	public LoginResultDto Login(String id, String pwd) {
		LoginResultDto authentication =  loginDao.Login(id, pwd);
		if(authentication.isSuccess()) {
			return new LoginResultDto(authentication.isSuccess(), authentication.getRole(), authentication.getName());
		} else {
			return new LoginResultDto(authentication.isSuccess(), authentication.getRole(), authentication.getName());
		}	
	}

	@Override
	public boolean Join(UserDto userdto) {
		boolean authentication =  loginDao.Join(userdto);
		if(authentication) {
			return true;
		} else {
			return false;
		}	
	}

}

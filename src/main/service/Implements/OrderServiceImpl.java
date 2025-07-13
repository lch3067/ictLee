package main.service.Implements;

import java.sql.SQLException;

import main.dao.OrderDao;
import main.dao.UserDao;
import main.dao.Implements.OrderDaoImpl;
import main.dao.Implements.UserDaoImpl;
import main.dto.OrderDto;
import main.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public int insertOrder(OrderDto odo, String userName) throws SQLException {
		OrderDao loginDao = OrderDaoImpl.getInstance();
		loginDao.insertOrder(odo, userName);
		return 0;
	}

}

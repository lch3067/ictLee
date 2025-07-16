package main.service.Implements;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.dao.OrderDao;
import main.dao.UserDao;
import main.dao.Implements.OrderDaoImpl;
import main.dao.Implements.UserDaoImpl;
import main.dto.CustomerDto;
import main.dto.OrderDto;
import main.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public boolean insertOrder(OrderDto odo, String userName) throws SQLException {
		OrderDao loginDao = OrderDaoImpl.getInstance();
		boolean result = loginDao.insertOrder(odo, userName);
		return result;
	}

	@Override
	public List<CustomerDto> selectEachCustomerOrderLIst(String userName) {
		OrderDao loginDao = OrderDaoImpl.getInstance();
		List<CustomerDto> result = loginDao.selectEachCustomerOrderLIst(userName);
		return result;
	}

}

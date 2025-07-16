package main.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.dto.CustomerDto;
import main.dto.OrderDto;
import main.service.OrderService;
import main.service.UserService;
import main.service.Implements.OrderServiceImpl;
import main.service.Implements.UserServiceImpl;

public class OrderController {
	
	OrderService login = new OrderServiceImpl();
	
	// 상품 주문
	public boolean order(OrderDto odo, String userName) throws SQLException {
		
		boolean result = login.insertOrder(odo, userName);
		
		return result;
		
	}
	
	// 고객별 주문한 상품조회
	public List<CustomerDto> customerEachProductFind(String userName) {
		List<CustomerDto> result = login.selectEachCustomerOrderLIst(userName);
		
		System.out.println(result);
		
		return result;
		
	}
	
}

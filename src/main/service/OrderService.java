package main.service;

import java.sql.SQLException;

import main.dto.OrderDto;

public interface OrderService {

	public int insertOrder(OrderDto odo, String userName) throws SQLException;
	
}

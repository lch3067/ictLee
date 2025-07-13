package main.dao;

import java.sql.SQLException;

import main.dto.OrderDto;

public interface OrderDao {

	public boolean insertOrder(OrderDto odo, String userName) throws SQLException;
	
}

package main.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.dto.CustomerDto;
import main.dto.OrderDto;

public interface OrderDao {

	public boolean insertOrder(OrderDto odo, String userName) throws SQLException;
	
	public List<CustomerDto> selectEachCustomerOrderLIst(String userName);
	
}





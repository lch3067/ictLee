package main.dao.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.dao.OrderDao;
import main.db.OracleConnectionManager;
import main.dto.OrderDto;

public class OrderDaoImpl implements OrderDao {

	private static OrderDaoImpl instance;

	public OrderDaoImpl() {
	}

	public static OrderDaoImpl getInstance() {
		if (instance == null) {
			instance = new OrderDaoImpl();
		}
		return instance;
	}

	@Override
	public boolean insertOrder(OrderDto dto, String userName) throws SQLException {

		String sql = """
				  INSERT ALL
				    INTO CUSTOMERS (CUSTOMER_ID, USER_ID, NAME)
				      VALUES (?,
				      	(SELECT USER_ID FROM USERS WHERE USERNAME = ?),
				      	?
				      )
				    INTO ORDERS (ORDER_ID, CUSTOMER_ID, WINE_NUMBER, PRODUCT_PRICE, DISCOUNT)
				      VALUES (?, ?, ?, ?, ?)
				  SELECT * FROM DUAL
				""";

		try (Connection conn = OracleConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// 1. CUSTOMERS 설정
			pstmt.setString(1, dto.getCusomter_Id());
			pstmt.setString(2, userName);
			pstmt.setString(3, userName);

			// 2. ORDERS 설정 (CUSTOMER_ID 다시 바인딩 뒤이드)
			pstmt.setString(4, dto.getOrder_Id());
			pstmt.setString(5, dto.getCusomter_Id());
			pstmt.setString(6, dto.getWine_Number());
			pstmt.setInt(7, dto.getProduct_Price());
			pstmt.setString(8, dto.isDiscount() ? "Y" : "N");

			int affected = pstmt.executeUpdate();
			if (affected == 1) {
				return true;
			} else {
				return false;
			}
		}
	}

}

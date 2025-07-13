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

		String mergeSql = """
				MERGE INTO CUSTOMERS tgt
				USING (
				  SELECT ? AS CUSTOMER_ID,
				         (SELECT USER_ID FROM USERS WHERE USERNAME = ?) AS USER_ID,
				         ? AS NAME
				  FROM DUAL
				) src
				ON (tgt.CUSTOMER_ID = src.CUSTOMER_ID)
				WHEN NOT MATCHED THEN
				  INSERT (CUSTOMER_ID, USER_ID, NAME)
				  VALUES (src.CUSTOMER_ID, src.USER_ID, src.NAME)
				""";

		String orderSql = """
				INSERT INTO ORDERS
				(ORDER_ID, CUSTOMER_ID, WINE_NUMBER, PRODUCT_PRICE, DISCOUNT)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (Connection conn = OracleConnectionManager.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pm = conn.prepareStatement(mergeSql);
					PreparedStatement po = conn.prepareStatement(orderSql)) {

				// 1) MERGE: CUSTOMERS 테이블 갱신 또는 삽입
				pm.setString(1, dto.getCusomter_Id());
				pm.setString(2, userName);
				pm.setString(3, userName);
				pm.executeUpdate();

				// 2) INSERT: ORDERS 테이블에 주문 정보 삽입
				po.setString(1, dto.getOrder_Id());
				po.setString(2, dto.getCusomter_Id());
				po.setString(3, dto.getWine_Number());
				po.setInt(4, dto.getProduct_Price());
				po.setString(5, dto.isDiscount() ? "Y" : "N");
				int orderCount = po.executeUpdate();

				if (orderCount == 1) {
					conn.commit();
					return true;
				} else {
					conn.rollback();
					return false;
				}
			}
		}
	}

}

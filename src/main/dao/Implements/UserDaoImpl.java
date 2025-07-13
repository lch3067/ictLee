package main.dao.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.dao.UserDao;
import main.db.OracleConnectionManager;
import main.dto.LoginResultDto;
import main.dto.UserDto;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance;

	public UserDaoImpl() {
	}

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public LoginResultDto Login(String id, String pwd) {

		String sql = "SELECT COUNT(*) AS cnt, MAX(ROLE) AS role, MAX(USERNAME) AS name FROM USERS WHERE USER_ID = ? AND PASSWORD = ?";
		try (Connection conn = OracleConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			try (var rs = pstmt.executeQuery()) {
	            if (rs.next() && rs.getInt("cnt") > 0) {
	                return new LoginResultDto(true, rs.getString("role"), rs.getString("name"));
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new LoginResultDto(true, null, null);
	}

	@Override
	public boolean Join(UserDto userdto) {
		
		System.out.println(userdto);
		
		String sql = "INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, EMAIL, BIRTH_DATE) "
				+ "VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
		try (Connection conn = OracleConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, userdto.getUserId());
			pstmt.setString(2, userdto.getUsername());
			pstmt.setString(3, userdto.getPassword());
			pstmt.setString(4, userdto.getEmail());
			pstmt.setString(5, userdto.getBirthDate().toString()); // 'YYYY-MM-DD'

			int rows = pstmt.executeUpdate();

			if (rows == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
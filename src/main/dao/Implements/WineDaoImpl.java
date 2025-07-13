package main.dao.Implements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.common.enums.WineOrigin;
import main.dao.WineDao;
import main.db.OracleConnectionManager;
import main.dto.LoginResultDto;
import main.dto.WineDto;

public class WineDaoImpl implements WineDao {

	// 전역변수 / 정적변수 | 공유
	private static WineDaoImpl instance;

	public WineDaoImpl() {
	}

	public static WineDaoImpl getInstance() {
		if (instance == null) {
			instance = new WineDaoImpl();
		}
		return instance;
	}

	@Override
	public List<WineDto> selectWineProduct() {

		WineDto dto = null;

		String sql = "SELECT ROW_NUMBER() OVER (ORDER BY WINE_NUMBER) AS idx, WINE_NUMBER, WINE_NAME, WINE_PRICE, REGION, COUNTRY, WINE_STRENGTH FROM WINES";

		List<WineDto> result = new ArrayList<>();

		try (Connection conn = OracleConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				dto = new WineDto();
				dto.setWine_idx(rs.getInt("idx"));
				dto.setWine_number(rs.getString("WINE_NUMBER"));
				dto.setWine_name(rs.getString("WINE_NAME"));
				dto.setWine_price(rs.getInt("WINE_PRICE"));
				
				String regionStr = rs.getString("REGION");
				WineOrigin region = WineOrigin.fromRegionName(regionStr); 
				dto.setWine_Region(region);

				String countryStr = rs.getString("COUNTRY");
				WineOrigin country = WineOrigin.fromCountryName(countryStr);
				dto.setWine_Country(country);
				
				dto.setWine_strength(rs.getString("WINE_STRENGTH"));
				result.add(dto);
			}

			System.out.println(dto);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace(); // 로깅용
			return Collections.emptyList(); // 실패 시 빈 리스트 반환
		}
	}

	@Override
	public int inserWineProduct(WineDto winedto) {
//		System.out.println("Dao부분");
//		System.out.println("BookDAOImpl - bookInsert()");
//
//		int result = 0;
//
//		String sql = "INSERT INTO MVC_BOARD_TBL(boardno, boardtitle, boardcontent, boardid) VALUES ((SELECT NVL(MAX(BOARDNO) + 1, 1) FROM MVC_BOARD_TBL), ?, ?, ?)";
//		try {
//
//			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
//			pstmt = conn.prepareStatement(sql); // SQL 작성
//			pstmt.setString(1, boardDto.getBoardTtitle()); // 앞에 1은 물음표 위치
//			pstmt.setString(2, boardDto.getBoardContents()); // 앞에 2은 물음표 위치
//			pstmt.setString(3, boardDto.getBoardId());
//
//			// 입력, 수정, 삭제 executeUpdate(); 1:성공 / 0:실패 -> 영향을 줌
//			// 조회 executeQuery(); -> 단지, 조회라 영향을 주지 않음
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return 0;
	}

	@Override
	public int updateWineProduct(WineDto winedto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWineProduct(String wine_number) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<WineDto> selectOneWineProduct(String wine_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WineDto> selectAllWineProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WineDto> selectBestOfBestWineProductTopFive() {
		// TODO Auto-generated method stub
		return null;
	}

}

package main.view;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import main.controller.OrderController;
import main.controller.WineController;
import main.dto.OrderDto;
import main.dto.WineDto;

public class OrderView {


	private String currnetUserId;
	
	private final Scanner scanner = new Scanner(System.in);
	
	OrderController oc = new OrderController();
	WineController wc = new WineController();

	public OrderView() {};
	
	public OrderView(String currnetUserId) {
		this.currnetUserId = currnetUserId;
	};
	
	public void oderDisplay(String role, String userName) throws SQLException {
		while (true) {
			System.out.println("┌────────────────────────────┐");
			System.out.println("│ 1. 주문하기                      ");
			System.out.println("│ 2. 고객별 주문한 상품 조회(관리자)     ");
			System.out.println("| 3. 고객별 할인 받은 내역 조회(관리자)  ");
			System.out.println("| 4. 로그아웃");
			System.out.println("└────────────────────────────┘");
			System.out.print("▶ 메뉴선택: ");
			String menu = scanner.nextLine().trim();

			switch (menu) {
			case "1":
				oc.order(order(), userName);
				break;
			case "2":
				if (role.equals("admin")) {

				}
				break;
			case "3":
				if (role.equals("admin")) {

				}
				break;
			case "4":
				return;
			default:
				System.out.println("올바른 메뉴를 선택하세요.");
			}
		}
	}

	public OrderDto order() {
		
		List<WineDto> result = wc.selelctProductInfoController();
		
		System.out.print(result);

		
	    OrderDto dto = new OrderDto();
	    
	    dto.setOrder_Id(RandomStringGenerator.generate(16));

	    
	    dto.setCusomter_Id(currnetUserId);

	    
	    System.out.println("상품을 선택하셨다면, 상품 번호 입력해 주세요.: ");
	    
	    WineDto wdo = result.get(scanner.nextInt());
	    dto.setWine_Number(wdo.getWine_number());
	    dto.setProduct_Price(wdo.getWine_price()*1000);
	    
	    scanner.nextLine().trim();

	    return dto;
	}

	public void customerEachSelect() {

	}

	public void customerEachDiscountSelect() {
		
	}
	
	public static class RandomStringGenerator {
        private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private static final SecureRandom RANDOM = new SecureRandom();

        public static String generate(int length) {
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int index = RANDOM.nextInt(CHARSET.length());
                sb.append(CHARSET.charAt(index));
            }
            return sb.toString();
        }
    }
}

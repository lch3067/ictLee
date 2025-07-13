package main.view;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.controller.CustomerController;
import main.controller.UserController;
import main.controller.OrderController;
import main.controller.WineController;
import main.dto.CustomerDto;
import main.dto.OrderDto;
import main.dto.UserDto;
import main.dto.WineDto;

public class Menu {

	// Controller
	private final CustomerController cc = new CustomerController();
	private final OrderController oc = new OrderController();
	private final WineController wc = new WineController();
	private final UserController uc = new UserController();

	// Member field
	private final Scanner scanner = new Scanner(System.in);
	private String currentUser = null;

	public Menu() {
	}

	public void displayMenu() throws Exception {
		while (true) {
			System.out.println("┌────────────────────────────┐");
			System.out.println("│ 1. 회원가입                  ");
			System.out.println("│ 2. 로그인                    ");
			System.out.println("│ 3. 종료                     ");
			System.out.println("└────────────────────────────┘");
			System.out.print("▶ 메뉴선택: ");
			String menu = scanner.nextLine().trim();

			switch (menu) {
			case "1":
				stateView(uc.Join(handleSignUp()), "join");
				break;
			case "2":
				if(handleSignOn()) {					
					stateView(true, "login");
					
				} else {
					stateView(false, "login");
				}
				break;
			case "3":
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("올바른 메뉴를 선택하세요.");
			}
		}
	}

	// 회원가입
	private UserDto handleSignUp() throws Exception {

		System.out.print("로그인 - 아이디 입력: ");
		String userId = scanner.nextLine().trim();

		System.out.print("로그인 - 비밀번호 입력: ");
		String password = scanner.nextLine().trim();

		System.out.print("로그인 - 이름 입력: ");
		String name = scanner.nextLine().trim();

		System.out.print("이메일 입력 (선택): ");
		String email = scanner.nextLine().trim();

		System.out.print("생년월일 입력 (YYYY-MM-DD): ");
		LocalDate birthDate = null;
		while (birthDate == null) {
			System.out.print("생년월일 입력 (YYYY-MM-DD): ");
			String bdInput = scanner.nextLine().trim();
			try {
				birthDate = LocalDate.parse(bdInput); // ISO 포맷 파싱
			} catch (DateTimeParseException e) {
				System.out.println("[오류] 날짜 형식이 잘못되었습니다. 다시 입력해주세요.");
			}
		}

		UserDto userdto = new UserDto();
		userdto.setUserId(userId);
		userdto.setPassword(password);
		userdto.setUsername(name);
		userdto.setEmail(email);
		userdto.setBirthDate(birthDate);

		return userdto;
	}

	// 로그인
	private boolean handleSignOn() {
		System.out.print("로그인 - 아이디 입력: ");
		String id = scanner.nextLine().trim();

		System.out.print("로그인 - 비밀번호 입력: ");
		String pw = scanner.nextLine().trim();

		if (uc.Login(id, pw)) {
			currentUser = id;
			return true;
		} else {
			return false;
		}
	}

	public void stateView(boolean result, String flag) {
		switch (flag) {
		case "join":
			if (result) {
				System.out.println("✅ 회원가입이 성공적으로 완료되었습니다.");
			} else {
				System.out.println("❌ 회원가입에 실패했습니다. 다시 시도해 주세요.");
			}
			break;
		case "login":
			if (result) {
				System.out.println("✅ 로그인에 성공하였습니다. " + currentUser + "님 환영합니다!");
			} else {
				System.out.println("❌ 로그인에 실패했습니다. 아이디 또는 비밀번호를 확인해 주세요.");
			}
			break;
		default:
			System.out.println("알 수 없는 요청입니다.");
		}
	}

}

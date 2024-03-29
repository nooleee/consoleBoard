package consoleBoard;

import java.util.Scanner;

public class Console {
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager = new UserManager();
	private BoardManager boardManager = new BoardManager();
	
	private int log;
	
	public Console() {
		log = -1;
		
	}
	
	private void printMenu() {
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]게시판");
		System.out.println("[6]파일");
		System.out.println("[0]종료");
	}
	
	private int inputNumber(String messege) {
		int number = -1;
		System.out.println(messege + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력 가능합니다.");
		}
		return number;
	}
	
	public void run() {
//		printBoard();
		while(true) {
			printMenu();
			int select = inputNumber("선택");
		}
	}
}

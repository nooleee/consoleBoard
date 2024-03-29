package consoleBoard;

import java.util.Scanner;

public class Console {
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager = new UserManager();
	private BoardManager boardManager = new BoardManager();
	private boolean isRun;
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int BOARD = 5;
	private final int FILE = 6;
	private final int EXIT = 0;
	
	private int log;
	
	public Console() {
		log = -1;
		isRun = true;
		
	}
	
	private void printStatus() {
		int UserSize = userManager.getUserSize();
		int BoardSize = boardManager.getBoardSize();
		String status = String.format("User size : %d\nBoard size : %d", UserSize, BoardSize);

		System.out.println("------------");
		System.out.println(status);
		System.out.println("log : " + log);
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

	private void runMenu(int select) {
		if(select < 0 || select > 6)
			return;
		
		if(select == JOIN)
//		else if(select == LEAVE)
//		else if(select == LOGIN)
//		else if(select == LOGOUT)
//		else if(select == BOARD)
//		else if(select == FILE)
//		else if(select == EXIT)
			isRun = false;
	}
	
	public void run() {
		printStatus();
//		printBoard();
		while(isRun) {
			printMenu();
			int select = inputNumber("선택");
			runMenu(select);
		}
	}
}

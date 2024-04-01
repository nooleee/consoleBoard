package consoleBoard;

import java.util.ArrayList;
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
	private final int EXIT = 0;
	
	private final int ADD = 1;
	private final int MODIFY = 2;
	private final int DELETE = 3;
	private final int CHECK_BOARD = 4;
	
	private final int MODIFY_TITLE = 1;
	private final int MODIFY_CONTENTS = 2;
	
	private int log;
	
	public Console() {
		log = -1;
		isRun = true;
	}
	
	private boolean checkLog() {
		return log == -1 ? true : false;
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
	
	private String inputString(String messege) {
		System.out.println(messege + " : ");
		return scan.next();
	}
	
	private void join() {
		String id = inputString("id");
		String password = inputString("password");
		
		if(!userManager.findUserByUserId(id)) {
			User user = userManager.createUser(id, password);
			printWelcomeMessage(user);
		}
		else
			System.err.println("이미 등록된 아이디입니다.");
	}
	
	private void printWelcomeMessage(User User) {
		String message = User.getCode() != 0 ? String.format("%s(%d) 회원님 환영합니다.", User.getId(), User.getCode())
				: "회원가입 실패";
		System.out.println(message);
	}
	
	private void leave() {
		String password = inputString("비밀번호 확인");
		User user = userManager.findUserByPassword(password);
		if(user.getCode() != 0) {
			userManager.deleteUser(user);
			System.out.println("회원탈퇴 완료");
		}
		else
			System.err.println("비밀번호를 다시 확인하세요");
	}
	
	private void login() {
		String id = inputString("id");
		String password = inputString("password");
		int code = 0;
		
		for(User user : userManager.findUserAll()) {
			if(user.getId().equals(id) && user.getPassword().equals(password))
				code = user.getCode();
		}
		
		if(code != 0) {
			log = code;
			System.out.println("로그인 완료");
		}
		else
			System.err.println("회원 정보를 확인해주세요.");
	}
	
	private void logout() {
		log = -1;
		System.out.println("로그아웃 되었습니다.");
	}
	
	private void board() {
		printBoardMenu();
		int choice = inputNumber("선택");
		runBoardMenu(choice);
	}
	
	private void printBoardMenu() {
		printBoardAll();
		System.out.println("[1]추가하기");
		System.out.println("[2]수정하기");
		System.out.println("[3]삭제하기");
		System.out.println("[4]내용확인");
		System.out.println("[0]종료");
	}
	
	private void add() {
		User user = userManager.findUserByUserCode(log);
		String title = inputString("제목");
		String contents = inputString("내용");
		user.getBoard().add(new Board(title, contents, log));
		Board board = new Board(title, contents, log);
		boardManager.createBoard(board);
		
		printBoardAll();
		System.out.println("게시물 등록 완료");
	}
	
	private void printBoardAll() {
		System.out.println("=============");
		int cnt = 1;
		for(int i = 0; i <= boardManager.getBoardSize(); i++) {
			Board target = boardManager.getBoardAll().get(i+1);
			if(target != null) {
				System.out.printf("[%d] ", cnt++);
				System.out.print(target);
			}
		}
		System.out.println("=============");
	}
	
	private void modify() {
		printSubModifyMenu();
		int sel = inputNumber("선택");
		runSubModifyMenu(sel);
	}
	
	private void modifyTitle() {
		printLogBoard();
		int num = inputNumber("수정을 원하는 게시물 번호");
		
		User user = userManager.getUserByUserCode(log);
		if(num < 0 || num > user.getBoardSize())
			return;
		
		String title = inputString("바꿀 제목");
		
		Board board = user.getBoardByCode(num);
		int target = boardManager.getBoardCode(board);
		
		boardManager.modifyTitle(target, title, board);
		
		ArrayList<Board> boards = userManager.getUserByUserCode(log).getBoard();
		boards.get(num-1).setTitle(title);
		System.out.println("제목 수정 완료");
	}
	
	private void modifyContents() {
		printLogBoard();
		int num = inputNumber("수정을 원하는 게시물 번호");
		
		User user = userManager.getUserByUserCode(log);
		if(num < 0 || num > user.getBoardSize())
			return;
		
		String contents = inputString("바꿀 내용");
		
		Board board = user.getBoardByCode(num);
		int target = boardManager.getBoardCode(board);
		
		boardManager.modifyContents(target, contents);
		
		ArrayList<Board> boards = userManager.getUserByUserCode(log).getBoard();
		boards.get(num-1).setContents(contents);
		System.out.println("내용 수정 완료");
	}
	
	private void runSubModifyMenu(int sel) {
		if(sel < 1 || sel > 2)
			return;
		
		if(sel == MODIFY_TITLE)
			modifyTitle();
		else if(sel == MODIFY_CONTENTS)
			modifyContents();
	}
	
	private void printSubModifyMenu() {
		System.out.println("[1]제목수정");
		System.out.println("[2]내용수정");
	}
	
	private void printLogBoard() {
		User user = userManager.getUserByUserCode(log);
		System.out.println(user);
	}

	private void delete() {
		printLogBoard();
		int num = inputNumber("삭제를 원하는 게시물 번호");
		User user = userManager.getUserByUserCode(log);
		if(num < 0 || num > user.getBoardSize())
			return;
		
		Board board = user.getBoardByCode(num);
		boardManager.deleteBoard(board);
		
		printBoardAll();
		ArrayList<Board> boards = userManager.getUserByUserCode(log).getBoard();
		boards.remove(num-1);
		System.out.println("게시물 삭제 완료");
	}
	
	private void checkBoard() {
		printSelectBoard();
	}
	
	private void printSelectBoard() {
		printBoardAll();
		int code = inputNumber("조회를 원하는 게시물 번호");
		if(code < 1 || code > boardManager.getBoardSize()) 
			return;
		
		Board target = boardManager.getBoardByCode(code);
		System.out.printf("제목 : %s\n내용 : %s\n", target.getTitle(), target.getContents());
	}
	
	private void runBoardMenu(int choice) {
		if(choice < 0 || choice > 4)
			return;
		
		if(choice == ADD)
			add();
		else if(choice == MODIFY)
			modify();
		else if(choice == DELETE)
			delete();
		else if(choice == CHECK_BOARD)
			checkBoard();
		else if(choice == EXIT)
			return;
		
	}

	private void runMenu(int select) {
		if(select < 0 || select > 6)
			return;
		
		if(select == JOIN && checkLog())
			join();
		else if(select == LEAVE && !checkLog())
			leave();
		else if(select == LOGIN && checkLog())
			login();
		else if(select == LOGOUT)
			logout();
		else if(select == BOARD && !checkLog())
			board();
		else if(select == EXIT)
			isRun = false;
	}
	
	public void run() {
//		printBoard();
		while(isRun) {
			printStatus();
			printMenu();
			int select = inputNumber("선택");
			runMenu(select);
		}
	}
}

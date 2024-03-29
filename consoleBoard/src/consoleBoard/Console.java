package consoleBoard;

public class Console {
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
	
	public void run() {
//		printBoard();
		while(true) {
			printMenu();
		}
	}
}

package consoleBoard;

import java.util.ArrayList;

public class User {
	private int code;
	private String id, password;
	private ArrayList<Board> board;
	
	public User() {
		
	}
	
	public User(String id, String password, int code) {
		this.id = id;
		this.password = password;
		this.code = code;
		board = new ArrayList<>();
	}
	
	public User(String id, String password, ArrayList<Board> board) {
		this.id = id;
		this.password = password;
		this.board = board;
	}
	
	// CRUD
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public ArrayList<Board> getBoard() {
		return this.board;
	}
	
	
	public User clone() {
		return new User(this.id, this.password, this.board);
	}
	
}

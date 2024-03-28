package consoleBoard;

import java.util.ArrayList;

public class User {
	private String id, password;
	private ArrayList<Board> board;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
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
	

	
}

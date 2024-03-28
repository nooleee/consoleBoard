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
	
	// CRUD
	
}

package consoleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardManager {
	private ArrayList<Board> list;
	private Map<String, Board> boardData = new HashMap<>(); // boardData = (title/contents, title/contents, ..)
	
	public BoardManager() {
		list = new ArrayList<>();
	}
	
	public Board createBoard(String title, String contents) {
		Board board = new Board(title, contents);
		list.add(board);
		return board.clone();
	}
	
	public void modifyTitle() {
		
	}
	
	public void modifyContents() {
		
	}
	
	public void deleteBoard() {
		
	}
}

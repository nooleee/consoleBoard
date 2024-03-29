package consoleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardManager extends Board {
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
	
	public boolean findBoardByTitle(String title) {
		for(Board board : list) {
			if(board.getTitle().equals(title))
				return true;
		}
		return false;
	}
	
	public Board getBoardByTilte(String title) {
		for(Board board : list) {
			if(board.getTitle().equals(title))
				return board;
		}
		return new Board();
	}
	
	public void modifyTitle(String title) {
		
	}
	
	public void modifyContents(String contents) {
		
	}
	
	public void deleteBoard() {
		
	}
	
	public int getBoardSize() {
		return list.size();
	}
}

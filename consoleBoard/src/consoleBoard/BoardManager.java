package consoleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardManager extends Board {
//	private ArrayList<Board> list;
	private int count;
	private Map<Integer, Board> boardData = new HashMap<>(); // boardData = (title/contents, title/contents, ..)
	
	public BoardManager() {
//		list = new ArrayList<>();
		count =1;
	}
	
	public Board createBoard(String title, String contents, int code) {
		Board board = new Board(title, contents, code);
		boardData.put(count, board);
		return board.clone();
	}
	
	public boolean findBoardByTitle(int code) {
		for(int i = 0; i < count; i++) {
			Board target = boardData.get(i);
			if(target.getCode() == code)
				return true;
		}
		return false;
	}
	
	public Board getBoardByTilte(int code) {
		for(int i = 0; i < count; i++) {
			Board target = boardData.get(i);
			if(target.getCode() == code)
				return target;
		}
		return new Board();
	}
	
	public void modifyTitle(int code, String title) {
		String contents = "";
		for(int i = 0; i < count; i++) {
			Board target = boardData.get(i);
			if(target.getCode() == code)
				contents = target.getContents();
		}
		
		
		Board newBoard = new Board(title, contents, code);
		boardData.replace(code, boardData.get(code), newBoard);
	}
	
	public void modifyContents(int code, String contents) {
		String title = "";
		for(int i = 0; i < count; i++) {
			Board target = boardData.get(i);
			if(target.getCode() == code)
				title = target.getTitle();
		}
		
		Board newBoard = new Board(title, contents, code);
		boardData.replace(code, boardData.get(code), newBoard);
	}
	
	public void deleteBoard(Board board) {
		for(int i = 0; i < count; i++) {
			if(boardData.get(i).equals(board))
				boardData.remove(i);
		}
	}
	
	
	public int getBoardSize() {
		return count;
	}
}

package consoleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardManager {
//	private ArrayList<Board> list;
	private int count;
	private int size;
	private Map<Integer, Board> boardData = new HashMap<>(); // boardData = (title/contents, title/contents, ..)
	
	public BoardManager() {
		size = boardData.size();
	}
	
	public int getCount() {
		return this.count;
	}
	
	
	public Board createBoard(Board board) {
		boardData.put(++ count, board);
		return board.clone();
	}
	
	public Map<Integer, Board> getBoardAll() {
		return boardData;
	}
	
	public boolean findBoardByTitle(int code) {
		for(int i = 1; i <= size; i++) {
			Board target = boardData.get(i);
			if(target.getCode() == code)
				return true;
		}
		return false;
	}
	
	public Board getBoardByCode(int code) {
		Board target = boardData.get(code);
		if(target.getCode() != 0)
				return target;
		return new Board();
	}
	
	public void modifyTitle(int code, String title, Board board) {
		String contents = "";
//		Board target = boardData.get(code);
		contents = board.getContents();
		
		
		Board newBoard = new Board(title, contents, code);
		boardData.replace(code, boardData.get(code), newBoard);
	}
	
	public void modifyContents(int code, String contents) {
		String title = "";
		Board target = boardData.get(code);
		title = target.getTitle();
		
		Board newBoard = new Board(title, contents, code);
		boardData.replace(code, boardData.get(code), newBoard);
	}
	
	public void deleteBoard(Board board) {
		int num = getBoardCode(board);
		boardData.remove(num);
		count--;
	}
	
//	public void deleteBoardAll(ArrayList<Board> board) {
//		for(int i = 0; i < board.size(); i++) {
//			Board temp = board.get(i);
//			for(int j = 1; j <= count; j++) {
//				Board target = boardData.get(j);
//				if(target != null && target.getTitle().equals(temp.getTitle()) && target.getContents().equals(temp.getContents())) {
//					boardData.remove(j);
//					count--;
//				}
//			}
//		}
//	}
	
	public int getBoardCode(Board board) {
		for(int i = 1; i <= size; i++) {
			Board target = boardData.get(i);
			if(target != null && target.getTitle().equals(board.getTitle()) && target.getContents().equals(board.getContents()))
				return i;
		}
		return -1;
	}
	
	public int getBoardSize() {
		return size;
	}
	

}

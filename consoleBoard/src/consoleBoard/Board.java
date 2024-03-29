package consoleBoard;

public class Board {
	private String title, contents;
	private int code;
	
	public Board() {
		
	}
	
	public Board(String title, String contents, int code) {
		this.title = title;
		this.contents = contents;
		this.code = code;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	public Board clone() {
		return new Board(this.title, this.contents, this.code);
	}
}

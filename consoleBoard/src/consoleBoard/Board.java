package consoleBoard;

public class Board {
	private String title, contents;
	
	public Board(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public String getTitle() {
		return this.title;
	}
}

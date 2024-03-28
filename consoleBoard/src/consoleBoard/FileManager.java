package consoleBoard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	
	public FileManager() {
		this.fileName = "Board.txt";
		this.file = new File(fileName);
	}
	
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private File file;
	private String fileName;
}

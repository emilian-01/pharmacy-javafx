package outer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	private FileWriter file;
	private PrintWriter pw;
	public Logger(String msg){
		try {
			file=new FileWriter("logs.txt",true);
			pw=new PrintWriter(file);
			pw.println(msg);
			pw.close();
		} catch (Exception e) {
			System.err.println("Write not right");
		} 
	}
	
}

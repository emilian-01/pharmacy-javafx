package outer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Bills {
	private FileWriter file;
	private PrintWriter pw;
	
	public Bills(String msg) {
		try {
			String a = String.valueOf((new Date()).getTime());
			file = new FileWriter("bill" + a + ".txt", true);
			//System.out.println(a);
			pw = new PrintWriter(file);
			pw.println(msg);
			pw.close();
		} catch (Exception e) {
			System.err.println("Bill create failed!");
		}
	}

}

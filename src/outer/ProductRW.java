package outer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import inner.ADMIN;
import inner.Birthday;
import inner.Product;

public class ProductRW {
	private final File fp;
	private ArrayList<Product> prod;

	public ProductRW() {
		fp = new File("prod.ser");
		prod = new ArrayList<Product>();
		if (!fp.exists()) {
			writeProd();
		} else {
			prod = readProd();
		}
	}

	public ArrayList<Product> readProd() {
		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fp));
			prod = (ArrayList<Product>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!");
		} catch (IOException e) {
			System.err.println("File not accessable!");
		}
		return prod;
	}

	private void writeProd() {
		try {
			FileOutputStream fos = new FileOutputStream(fp);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(prod);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
		readProd();
	}

	public void addProd(Product e) {
		prod.add(e);
		writeProd();
	}

	public void remove(Product e) {
		prod.remove(e);
		writeProd();
	}
}

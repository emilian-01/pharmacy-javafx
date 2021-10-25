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
import inner.Employee;
import inner.Type;

public class UserRW {
	private final File fu;
	private ArrayList<Employee> emp;

	public UserRW() {
		fu = new File("emp.ser");
		emp = new ArrayList<Employee>();
		if (!fu.exists()) {
			writeEmp();
		} else {
			emp = readEmp();
		}
	}

	public ArrayList<Employee> readEmp() {
		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fu));
			emp = (ArrayList<Employee>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!");
		} catch (IOException e) {
			System.err.println("File not accessable!");
		}
		return emp;
	}

	private void writeEmp() {
		try {
			FileOutputStream fos = new FileOutputStream(fu);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			if (emp.isEmpty()) {
				emp.add(new ADMIN("admin", "admin", "User", "ADMIN", new Birthday("10/2/2018")));
			}
			oos.writeObject(emp);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
		readEmp();
	}

	public Employee checkUser(String username, String password) {
		for (Employee x : emp) {
			if (username.equals(x.getUsername()) && x.getPassword().equals(password)) {
				return x;
			}
		}
		return null;
	}

	public void addEmp(Employee e) {
		emp.add(e);
		writeEmp();
	}

	public void remove(Employee e) {
		emp.remove(e);
		writeEmp();
	}
}

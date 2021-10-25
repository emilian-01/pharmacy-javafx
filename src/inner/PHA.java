package inner;

public class PHA extends Employee {

	public PHA(String user, String pass, String name, String surname, Birthday bdt) {
		super(user, pass, name, surname, bdt);
		setType(Type.PHA);
	}

	public String toString() {
		return "PHA: " + super.getName() + " " + super.getSurname();
	}
}

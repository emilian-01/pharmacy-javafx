package inner;

public class Employee extends User {

	private String name;
	private String surname;
	private Birthday bdt;

	public Employee(String user, String pass, String name,
			String surname, Birthday bdt) {
		super(user, pass);
		this.name = name;
		this.surname = surname;
		this.bdt = bdt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Birthday getBdt() {
		return bdt;
	}

	public void setBdt(Birthday bdt) {
		this.bdt = bdt;
	}

	@Override
	public void setType(Type type) {
		super.type=type;
	}
	public String toString(){
		return "Employee";
	}
}

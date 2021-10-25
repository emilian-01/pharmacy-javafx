package inner;

public class ADMIN extends Employee {

	public ADMIN(String user, String pass, String name, String surname,
			Birthday bdt) {
		super(user, pass, name, surname, bdt);
		setType(Type.ADMIN);
	}
	public String toString(){
		return "ADMIN:"+super.getName()+" "+super.getSurname();
	}
}

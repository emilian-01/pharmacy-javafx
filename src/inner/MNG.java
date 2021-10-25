package inner;

public class MNG extends Employee{

	public MNG(String user, String pass, String name, String surname,
			Birthday bdt) {
		super(user, pass, name, surname, bdt);
		setType(Type.MNG);
	}
	public String toString(){
		return "Manager: "+super.getName()+" "+super.getSurname();
	}
}

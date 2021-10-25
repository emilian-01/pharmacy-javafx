package inner;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable {
	private int pid;
	private String name;
	private String surname;
	private Birthday bdy;
	private RegDay rd;
	private ArrayList<Record> arec;
	public Patient(int pid, String name, String surname, Birthday bdy,
			RegDay rd, ArrayList<Record> arec) {
		super();
		this.pid = pid;
		this.name = name;
		this.surname = surname;
		this.bdy = bdy;
		this.rd = rd;
		this.arec = arec;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public Birthday getBdy() {
		return bdy;
	}
	public void setBdy(Birthday bdy) {
		this.bdy = bdy;
	}
	public RegDay getRd() {
		return rd;
	}
	public void setRd(RegDay rd) {
		this.rd = rd;
	}
	public ArrayList<Record> getArec() {
		return arec;
	}
	public void setArec(ArrayList<Record> arec) {
		this.arec = arec;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", name=" + name + ", surname="
				+ surname + ", bdy=" + bdy + ", rd=" + rd + ", arec=" + arec
				+ "]";
	}
	
}

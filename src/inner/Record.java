package inner;

public class Record {
	private int Rid;
	private String diagnosis;
	private String recet;
	private MNG doktori;
	private RegDay rd;
	public Record(int rid, String diagnosis, String recet, MNG doktori, RegDay rd) {
		super();
		Rid = rid;
		this.diagnosis = diagnosis;
		this.recet = recet;
		this.doktori = doktori;
		this.rd = rd;
	}
	public int getRid() {
		return Rid;
	}
	public void setRid(int rid) {
		Rid = rid;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getRecet() {
		return recet;
	}
	public void setRecet(String recet) {
		this.recet = recet;
	}
	public MNG getDoktori() {
		return doktori;
	}
	public void setDoktori(MNG doktori) {
		this.doktori = doktori;
	}
	public RegDay getRd() {
		return rd;
	}
	public void setRd(RegDay rd) {
		this.rd = rd;
	}
	@Override
	public String toString() {
		return "Record [Rid=" + Rid + ", diagnosis=" + diagnosis + ", recet="
				+ recet + ", doktori=" + doktori + ", rd=" + rd + "]";
	}
	
}

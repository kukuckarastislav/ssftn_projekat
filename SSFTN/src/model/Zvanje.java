package model;

public enum Zvanje {
	
	Saradnik_u_nastavi(1), asistent(2),asistent_sa_doktoratom(3),docent(4),vanredni_profesor(5),redovni_profesor(6),profesor_emeritus(7);
	int zvanje;
	
	private Zvanje() {}
	private Zvanje(int zvanje) {this.zvanje = zvanje;}
	
	private static String[] values = {"Saradnik u nastavi","Asistent","Asistent sa doktoratom","Docent","Vanredni profesor","Redovni profesor","Profesor emeritus"};
	
	public String toString() {
		return values[this.ordinal()];
	}
	
	public static String[] getValues() {
		
		return values;
	}

}

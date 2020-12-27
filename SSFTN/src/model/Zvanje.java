package model;

public enum Zvanje {
	
	Saradnik_u_nastavi(1), asistent(2),asistent_sa_doktoratom(3),docent(4),vanredni_profesor(5),redovni_profesor(6),profesor_emeritus(7);
	int zvanje=0;;
	
	private Zvanje() {}
	private Zvanje(int zvanje) {this.zvanje = zvanje;}
	
	private static String[] opis = {"Saradnik u nastavi","Asistent","Asistent sa doktoratom","Docent","Vanredni profesor","Redovni profesor","Profesor emeritus"};
	
	public String toString() {
		return opis[this.ordinal()];
	}
	
	public static String[] getValues() {
		
		return opis;
	}
	
	   public static Zvanje byOrdinal(int ord) {
	        for (Zvanje z : Zvanje.values()) {
	            if (z.zvanje == ord) {
	                return z;
	            }
	        }
	        return null;
	    }
	


}

package model;

public enum Titula {
	
	BSc(1), MSc(2),mr(3),dr(4),profDr(5);
	
	int titula =0;
	
	private Titula() {}
	private Titula(int titula) {this.titula = titula;}
	
	private static String[] opis = {"BSc","MSc","mr","dr","profDr"};
	
	public String toString(Titula titula2) {
		return opis[this.ordinal()];
	}
	
	public static String[] getValues() {
		
		return opis;
	}
	

	   public static Titula byOrdinal(int ord) {
	        for (Titula t : Titula.values()) {
	            if (t.titula == ord) {
	                return t;
	            }
	        }
	        return null;
	    }
	


}

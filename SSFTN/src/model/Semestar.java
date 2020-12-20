package model;

public enum Semestar {
	
	ZIMSKI(1), LETNJI(2);
	int semestar;
	
	private Semestar() {}
	private Semestar(int semestar) {this.semestar = semestar;}
	
	private String[] opis = {"Zimski","Letnji"};
	
	public String toString() {
		return opis[this.ordinal()];
	}
	

}

package model;

public enum Status {

	B(1),S(2);
	int status;
	
	private Status() {}
	private Status(int status) {this.status = status;}
	
	private String[] opis = {"Budzet", "Samofinansiranje"};
	
	public String toString() {
		return opis[this.ordinal()];
	}
	
}

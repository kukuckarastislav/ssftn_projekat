package model;

import java.util.ArrayList;

import model.Predmet;
//import model.Semestar;

public class BazaPredmeti {
	
private static BazaPredmeti instance = null;
	
	public static BazaPredmeti getInstance() {
		if(instance == null) {
			instance = new BazaPredmeti();
		}
		return instance;
	}
	
	private ArrayList<Predmet> alPredmeti;
	private ArrayList<String> alKolone;
	
	
private BazaPredmeti() {
		
		
		// initPredmets() 		// neka metoda koja ce da ucita u bazu Predmete pri paljenju app
		alPredmeti = new ArrayList<Predmet>();
		
		
		alKolone = new ArrayList<String>();
		alKolone.add("Sifra predmeta");
		alKolone.add("Naziv predmeta");
		alKolone.add("Broj ESPB bodova");
		alKolone.add("Godina u kojoj se predmet izvodi");
		alKolone.add("Semestar u kome se predmet izvodi");

	}
	
	
	public ArrayList<Predmet> getPredmeti(){
		return alPredmeti;
	}
	
	public void setPredmeti(ArrayList<Predmet> Predmeti) {
		alPredmeti = Predmeti;
	}
	
	public int getBrKolona() {
		return 5;
	}
	
	public String getNazivKolona(int index) {
		return alKolone.get(index);
	}
	
	public Predmet getPredmet(int rowIndex) {
		return alPredmeti.get(rowIndex);
	}
	
	public String getVrednostU(int x, int y) {
		Predmet predmet = alPredmeti.get(x);
		switch (y) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojESPBbodova());
		case 3:
			return Integer.toString(predmet.getGodinaStudijaUKojojSePredmetIzvodi());
		case 4:
			return predmet.getSemestar().toString();
			
		default:
			return null;
		}
	}
	
	public void dodajPredmeta(Predmet predmet) {
		alPredmeti.add(predmet);
	}

	public void dodajPredmeta(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBbodova) 
	{
		Predmet Predmet = new Predmet(sifraPredmeta,nazivPredmeta, semestar,
				godinaStudijaUKojojSePredmetIzvodi,predmetniProfesor,brojESPBbodova);
		alPredmeti.add(Predmet);
	}
	
	
	
	public void izbrisiPredmeta(String sifraPredmeta) {
		for (Predmet Predmet : alPredmeti) {
			if(Predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				alPredmeti.remove(Predmet);
				break;
			}
		}
	}
	
	
	public void izmeniPredmeta(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBbodova) 
	{
		for (Predmet predmet : alPredmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				
		predmet.setSifraPredmeta(sifraPredmeta);
		predmet.setNazivPredmeta(nazivPredmeta);
		predmet.setSemestar(semestar);
		predmet.setGodinaStudijaUKojojSePredmetIzvodi(godinaStudijaUKojojSePredmetIzvodi);
		predmet.setPredmetniProfesor( predmetniProfesor);
		predmet.setBrojESPBbodova(brojESPBbodova);
				
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}


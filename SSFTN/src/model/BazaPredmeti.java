package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	private ArrayList<Predmet> trazeniPredmeti;
	private boolean SearchMode;
	
	private ArrayList<Predmet> predmetiIzabranogProfesora;
	private ArrayList<String> trazeneKolone;


	private void initPredmets() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		Date datumRodjenja = null;
		try {
			datumRodjenja = dateFormat.parse("7.1.2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Profesor p1=new Profesor("Petrovic", "Veljko",datumRodjenja, "Novi sad", "66666",
				"helou@gmail","Radnicka 30", "123456789", Titula.dr, Zvanje.redovni_profesor);
		
		
		
		Predmet pr1 = new Predmet("E13", "Programski Jezici i Strukture Podataka", Semestar.ZIMSKI, 1, 9);
		
		pr1.setPredmetniProfesor(p1);
		
		Predmet pr2 = new Predmet("E15", "OISISI", Semestar.ZIMSKI, 3, 6);
		Predmet pr3 = new Predmet("AN1", "Analiza 1", Semestar.ZIMSKI, 1, 9);
		Predmet pr4 = new Predmet("ARH", "Arhitektura Racunara", Semestar.LETNJI, 1, 9);
		Predmet pr5 = new Predmet("MISS", "Modelovanje i simulacija sistema", Semestar.ZIMSKI, 2, 8);
		
		alPredmeti.add(pr1);
		alPredmeti.add(pr2);
		alPredmeti.add(pr3);
		alPredmeti.add(pr4);
		alPredmeti.add(pr5);
	}
	
	
	private BazaPredmeti() {
		
		
		// initPredmets() 		// neka metoda koja ce da ucita u bazu Predmete pri paljenju app
		alPredmeti = new ArrayList<Predmet>();
		predmetiIzabranogProfesora = new ArrayList<Predmet>();
		initPredmets();
		
		alKolone = new ArrayList<String>();
		alKolone.add("Sifra predmeta");
		alKolone.add("Naziv predmeta");
		alKolone.add("Broj ESPB bodova");
		alKolone.add("Godina u kojoj se predmet izvodi");
		alKolone.add("Semestar u kome se predmet izvodi");
		
		trazeneKolone=new ArrayList<String>();
		trazeneKolone.add("Sifra");
		trazeneKolone.add("Naziv");
		trazeneKolone.add("Godina");
		trazeneKolone.add("Semestar");
				

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
	public String getNazivTrazenihKolona(int index) {
		return trazeneKolone.get(index);
	}
	
	public Predmet getPredmet(int rowIndex) {
		return alPredmeti.get(rowIndex);
	}
	
	public String getVrednostU(int x, int y) {
		
		if(SearchMode == false) {
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
		}else {
		Predmet predmet = trazeniPredmeti.get(x);
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
	}
	
	public String getPredmetiProfesora(int x,int y) {
		
		Predmet predmet = predmetiIzabranogProfesora.get(x);
		switch (y) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getGodinaStudijaUKojojSePredmetIzvodi());
		case 3:
			return predmet.getSemestar().toString();
			
		default:
			return null;
		}
	}
	
	public void dodajPredmet(Predmet predmet) {
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
	
	
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
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


	public boolean jedinstvenaSifra(String novaSifra) {
		for (Predmet predmet : alPredmeti) {
			if(predmet.getSifraPredmeta().equals(novaSifra)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isSearchMode() {
		return SearchMode;
	}
	public void setSearchMode(boolean searchMode) {
		SearchMode = searchMode;
	}
	
	public ArrayList<Predmet> getTrazeniPredmeti() {
		return trazeniPredmeti;
	}

	public void setTrazeniPredmeti(ArrayList<Predmet> trazeniPredmeti) {
		this.trazeniPredmeti = trazeniPredmeti;
	}
	
	public void prepareSubjectDisplay(Profesor prof) {
		for(Predmet p: alPredmeti) {
			if(p.getPredmetniProfesor()!=null) {
				if(prof.getIme().equals(p.getPredmetniProfesor().getIme()))
					predmetiIzabranogProfesora.add(p);
			}
		}		
	}
	

	

	public ArrayList<Predmet> getPredmetiIzabranogProfesora() {
		return predmetiIzabranogProfesora;
	}
	public void setPredmetiIzabranogProfesora(ArrayList<Predmet> predmetiIzabranogProfesora) {
		this.predmetiIzabranogProfesora = predmetiIzabranogProfesora;
	}
	
	public void podajPredmetProfesoru(Predmet p) {
		predmetiIzabranogProfesora.add(p);
	}
	
	

}


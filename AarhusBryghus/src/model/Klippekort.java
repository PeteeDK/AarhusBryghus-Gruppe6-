package model;

import java.util.ArrayList;

import model.betalingsform.IBetalingsform;

public class Klippekort extends Produkt implements IBetalingsform {

	private int antalKlip;
	private final ArrayList<Klip> klipEnheder = new ArrayList<>();
	 
	public Klippekort(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		initKlip();
		antalKlip = klipEnheder.size();
	}
	
	private void initKlip() {
		int i = 1;
		while(i < 5) {
			Klip k = createKlip(i);
			klipEnheder.add(k);
			i++;
		}
	}
	
	public int antalKlipTilbage() {
		return antalKlip;
	}
 
	@Override
	public String registrerBetaling() {
		for(Klip k : klipEnheder) {
			if(!k.isBrugt()) {
				k.setBrugt(true);
				String message = "Betalt med klippekort: " + "klip nr. " + k.getNr() + " af 4 er brugt";
				antalKlip--;
				return message;
			}
		}
		return "Betalingen med klippekort blev ikke gennemført. Alle klip er opbrugt";

	}
	
	public ArrayList<Klip> getKlipEnheder(){
		return new ArrayList<>(klipEnheder);
	}
	
	public Klip createKlip(int nr) {
		Klip klip = new Klip(nr);
		klipEnheder.add(klip);
		return klip;
	}

	public int getAntalKlip() {
		return antalKlip;
	}

	public void setAntalKlip(int antalKlip) {
		this.antalKlip = antalKlip;
	}
	
}

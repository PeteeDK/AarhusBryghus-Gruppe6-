package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.IBetalingsform;


public class Klippekort extends Produkt implements IBetalingsform {

	private int antalKlip;
	private final ArrayList<Klip> klipEnheder = new ArrayList<>();
	private LocalDate købsdato;
	private int id = 1;
	 
	public Klippekort(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		setId(getId() + Controller.getSolgteKlippekort().size());	
		initKlip();
		this.antalKlip = klipEnheder.size(); 
		købsdato = LocalDate.now();
	}
	
	private void initKlip() {
		int i = 1;
		while(i < 5) {
			Klip k = createKlip(i);
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
		if(antalKlip < 0) {
			throw new IllegalArgumentException("Antal klip kan ikke være negativ");
		}
		this.antalKlip = antalKlip;
	}

	public LocalDate getKøbsdato() {
		return købsdato;
	}

	public void setKøbsdato(LocalDate købsdato) {
		this.købsdato = købsdato;
	}

	@Override
	public String toString() {
		return "Klippekort [antalKlip=" + antalKlip + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}

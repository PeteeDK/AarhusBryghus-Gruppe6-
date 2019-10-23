package nyArkitektur;

import java.util.ArrayList;

public class Klippekort extends Produkt implements IBetalingsform {

	private double fredagsbarPris;
	private double butiksPris;
	private int antalKlip;
	private final ArrayList<Klip> klipEnheder = new ArrayList<>();
	
	public Klippekort(String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
		super(kategori, produktNavn);
		this.fredagsbarPris = fredagsbarPris;
		this.butiksPris = butiksPris;
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
	public double getPris() {
		if(Salgssituation.isFredagsbarMode()) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
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

	public double getFredagsbarPris() {
		return fredagsbarPris;
	}

	public void setFredagsbarPris(double fredagsbarPris) {
		this.fredagsbarPris = fredagsbarPris;
	}

	public double getButiksPris() {
		return butiksPris;
	}

	public void setButiksPris(double butiksPris) {
		this.butiksPris = butiksPris;
	}

	public int getAntalKlip() {
		return antalKlip;
	}

	public void setAntalKlip(int antalKlip) {
		this.antalKlip = antalKlip;
	}
	
	
	
}

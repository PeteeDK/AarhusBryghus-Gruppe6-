package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;


/**
 * Anlæg indeholder information omkring udlejning af fadølsanlæg. Klassen indholder en liste med elementer 
 * af klassen Pris, der anvendes til at beregne prisen for hhv. pant ved udlejningen og forbruget af
 * kulsyrer og fustager ved aflevering. Derfor kan den kun tage imod priser, hvor produktet entener kulsyre
 * eller fustage 
 * @author Erik Kato Ipsen
 */

public class Anlæg extends Produkt {

	private boolean afleveret;
	private double brugtFustageLiter;
	private double brugtKulsyreKg;
	private ArrayList<Pris> tilbehørsPriser = new ArrayList<>();
	private LocalDate købsdato;
	private int id = 1; 
 
	 
	public Anlæg(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		setKøbsdato(LocalDate.now());
		setId(getId() + Controller.getSolgteAnlæg().size());	
	}
  
	/**
	 * Metoden kaldes i getPris() i klassen, når beløbet for pant af tilbehør som fustage og kulsyre skal gøres op
	 * eller forbruget af disse varer 
	 * @return ved aflevering returneres prisen af forbruget på kulsyrer og fustager og panten trækkes fra og ved udlejning (når alvering = false) returneres panten
	 */
	public double beregnForbrug() {
		double pris = 0;
		if(afleveret) { 
			for(Pris t : tilbehørsPriser) {
				if(t.getProdukt().getKategori().equals("fustage")) {
					pris += t.getPris() * brugtFustageLiter;	//t.getPris() er vel at mærke pris pr. liter
				}else if(t.getProdukt().getKategori().equals("kulsyre")) {
					pris += t.getPris() * brugtKulsyreKg;	//t.getPris er vel at mærke pris pr. kg
				}
			}
			pris -= beregnPant();
		}else {
			pris = beregnPant();
		}
		return pris; 
	}
	
	/**
	 * Hjælpe metode til beregnForbrug()
	 * @return returnerer beløbet af den samlede pant, der er tilføjet som priser i listen tilbehør
	 */
	private double beregnPant() {
		double pant = 0;
		for(Pris t : tilbehørsPriser) {
			if(t.getProdukt().getKategori().equals("fustage") || t.getProdukt().getKategori().equals("kulsyre")) {
				pant += ((Tilbehør)t.getProdukt()).getPant();
			}
		}
		return pant;
	}

	public boolean isAfleveret() {
		return afleveret;
	}

	public void setAfleveret(boolean afleveret) {
		this.afleveret = afleveret;
	}

	public double getBrugtFustagemængde() {
		return brugtFustageLiter;
	}

	/**
	 * Den angivede brugte mængde øl fra fustager valideres, således at den brugte mængde ikke kan overstige den indkøbte mængde
	 * @param brugtFustageMængde liter øl der er forbrugt
	 */
	public void setBrugtFustagemængde(double brugtFustageMængde) {
		if(brugtFustageMængde < 0) {
			throw new IllegalArgumentException("brugt fustagemængde kan ikke være negativ");
		}
		double samletFustageMængde = 0;
		for(Pris p : tilbehørsPriser) {
			if(p.getProdukt().getKategori().equals("fustage")) {
				samletFustageMængde += ((Tilbehør)p.getProdukt()).getMængde();
			}
		} 
		if(brugtFustageMængde <= samletFustageMængde) {
			this.brugtFustageLiter = brugtFustageMængde;
		}else {
			throw new ArithmeticException("brugt fustage-mængde kan ikke overstiger indkøbt mængde");
		}
	}

	public double getBrugtKulsyremængde() {
		return brugtKulsyreKg;
	}

	/**
	 * Mængden af brugt kulsyres valideres, således at den brugte mængde ikke kan overstige den indkøbte mængde
	 * @param brugtKulsyreMængde kg kulsyre der er forbrugt
	 */
	public void setBrugtKulsyremængde(double brugtKulsyreMængde) {
		if(brugtKulsyreMængde < 0) {
			throw new IllegalArgumentException("brugt kulsyremængde kan ikke være negativ");
		}
		double samletKulsyreMængde = 0;
		for(Pris p : tilbehørsPriser) {
			if(p.getProdukt().getKategori().equals("kulsyre")) {
				samletKulsyreMængde += ((Tilbehør)p.getProdukt()).getMængde();
			}
		}
		if(brugtKulsyreMængde <= samletKulsyreMængde) {
			this.brugtKulsyreKg = brugtKulsyreMængde;
		}else {
			throw new ArithmeticException("brugt kulsyre-mængde kan ikke overstige indkøbt mængde");
		}
	}
	
	/**
	 * De tilføjede priser til listen tilbehørsPriser valideres således, at det kun er priser med produkterne fustage og kulsyre tilføjes
	 * @param t tilbehør til udlejningen af anlæg - altså indkøb af fustager og kulsyrer
	 */
	public void addTilbehør(Pris t) {
		if(!tilbehørsPriser.contains(t)) {
			if(t.getProdukt().getKategori().equals("fustage") || t.getProdukt().getKategori().equals("kulsyre")) {
				tilbehørsPriser.add(t);
			}
		}
	}
	
	public void removeTilbehør(Pris t) {
		if(tilbehørsPriser.contains(t)) {
			tilbehørsPriser.remove(t);
		}
	}
	
	public ArrayList<Pris> getTilbehør(){
		return new ArrayList<>(tilbehørsPriser);
	}

	/**
	 * Hvert Produkt-objekt i hvert Pris-objekt i tilbehørsPriser lægges i en ny liste som returneres
	 */
	public ArrayList<Produkt> getTilbehørsProdukter(){
		ArrayList<Produkt> produkter = new ArrayList<>();
		for(Pris p : tilbehørsPriser) {
			Produkt produkt = p.getProdukt();
			produkter.add(produkt); 
		}
		return produkter;
	}

	@Override
	public String toString() {
		return "Anlæg [afleveret=" + afleveret + ", tilbehørsPriser=" + tilbehørsPriser
				+ "]";
	}

	public LocalDate getKøbsdato() {
		return købsdato;
	}

	public void setKøbsdato(LocalDate købsdato) {
		this.købsdato = købsdato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

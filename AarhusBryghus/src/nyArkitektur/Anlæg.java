package nyArkitektur;

import java.util.ArrayList;

public class Anlæg {

	private String produktNavn;
	private double pris;
	private boolean afleveret;
	private double brugtFustagemængde;
	private double brugtKulsyremængde;
	private int antal;
	private ArrayList<Produktgruppe> tilbehør = new ArrayList<>();
	
	
	public Anlæg(String produktNavn, double pris, boolean afleveret, double brugtFustagemængde, double brugtKulsyremængde, int antal) {
		this.produktNavn = produktNavn;
		this.pris = pris;
		this.afleveret = afleveret;
		this.brugtFustagemængde = brugtFustagemængde;
		this.brugtKulsyremængde = brugtKulsyremængde;
		this.antal = antal;
	}


	public double beregnPris() {
		if(afleveret) {
			for(Produktgruppe pg : tilbehør) {
				if(pg.equals("fustage")) {
					pris += (pg.getMængde() - (pg.getMængde() - brugtFustagemængde)) * pg.getButiksPris() - pg.getPant();
				}else if(pg.equals("kulsyre")) {
					pris += (pg.getMængde() - (pg.getMængde() - brugtKulsyremængde)) * pg.getButiksPris();
				}
			}
			
		}else{
			pris = 0;
		}
		
		return pris;
	}
	
	
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	public boolean isAfleveret() {
		return afleveret;
	}
	public void setAfleveret(boolean afleveret) {
		this.afleveret = afleveret;
	}
	public double getBrugtFustagemængde() {
		return brugtFustagemængde;
	}
	public void setBrugtFustagemængde(double brugtFustagemængde) {
		this.brugtFustagemængde = brugtFustagemængde;
	}
	public double getBrugtKulsyremængde() {
		return brugtKulsyremængde;
	}
	public void setBrugtKulsyremængde(double brugtKulsyremængde) {
		this.brugtKulsyremængde = brugtKulsyremængde;
	}
	public int getAntal() {
		return antal;
	}
	public void setAntal(int antal) {
		this.antal = antal;
	}
	
	public void addProduktgruppe(Produktgruppe p) {
		tilbehør.add(p);
	}
		
	
}

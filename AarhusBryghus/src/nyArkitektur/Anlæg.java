package nyArkitektur;

import java.time.DayOfWeek;
import java.util.ArrayList;


public class Anlæg extends Produkt {

	private boolean afleveret;
	private double brugtFustagemængde;
	private double brugtKulsyremængde;
	private ArrayList<Produkt> tilbehør = new ArrayList<>();
	private double anlægsPris;

	
	public Anlæg(String kategori, String produktNavn, double pris, boolean afleveret, double brugtFustagemængde,
			double brugtKulsyremængde) {
		super(kategori, produktNavn, pris);
		this.afleveret = afleveret;
		this.brugtFustagemængde = brugtFustagemængde;
		this.brugtKulsyremængde = brugtKulsyremængde;
		initAnlægspris();
	}

	//prisen for anlægget bliver sat i constructuren uanset om der er tale om fredagsbarPris eller butiksPris
	//derved skal anlægsPris blot initialiseres med én af priserne fra superklassen
	private void initAnlægspris() {
		anlægsPris = super.getButiksPris();
	}
	

	public double beregnPris() {
		if(afleveret) {
			for(Produkt p : tilbehør) {
				if(p.getKategori().equals("fustage")) {
					anlægsPris += brugtFustagemængde * ((Fustage)p).getPrisPrLiter();
				}else if(p.getKategori().equals("kulsyre")) {
					anlægsPris += brugtKulsyremængde * ((Kulsyre)p).getPris();
				}
			}
		}else{
			anlægsPris = 0;
		}
		return anlægsPris;
	}
	
	//beregnPris() "oversættes" til getPris() for at kunne anvende "getPris()" ensartet i Salg
	public double getPris() {
		return beregnPris();
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
	
	public void addProdukt(Produkt p) {
		tilbehør.add(p);
	}
		
	
}

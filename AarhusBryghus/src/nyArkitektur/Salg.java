package nyArkitektur;

import java.util.ArrayList;

import kasseret.Produktgruppe;

public class Salg {

	private int id;
	private double samletPris;
	private ArrayList<Rundvisning> rundvisninger = new ArrayList<>();
	private ArrayList<Anlæg> anlægEnheder = new ArrayList<>();
	private ArrayList<Produktgruppe> produktgruppeEnheder = new ArrayList<>();
	private Salgssituation salgssituation;
	private Betalingsform betalingsform;
	
	public Salg(int id) {
		this.id = id;
	}
	
	public double beregnSamletPris() {
		
		for(Rundvisning r : rundvisninger) {
			samletPris += r.beregnPris();
		}
		
		for(Anlæg a : anlægEnheder) {
			samletPris += a.beregnPris();
		}
		
		for(Produktgruppe p : produktgruppeEnheder) {
			samletPris += p.beregnPris();
		}
		
		return samletPris;
		
	}
	
	
	public void addProduktgruppe(Produktgruppe p) {
		produktgruppeEnheder.add(p);
	}
	
	public void addAnlægEnheder(Anlæg a) {
		anlægEnheder.add(a);
	}
	
	public void addRundvisning(Rundvisning r) {
		rundvisninger.add(r);
	}
}

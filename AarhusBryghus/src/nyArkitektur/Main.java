package nyArkitektur;

import kasseret.Produktgruppe;

public class Main {

	public static void main(String[] args) {

		//registrer Produktgruppe
		
		//flaske, fadøl, fustage:
		//String kategori, String produktnavn, double mængde, double fredagsPris, double butiksPris, 
		//double ølstørrelse, double pant, String pakkeindhold
		Produktgruppe p1 = new Produktgruppe("flaske","ale",0,50,36,0,0,"");
		Produktgruppe p2 = new Produktgruppe("fadøl","carlsberg",0,30,0,40,0,"");
		Produktgruppe p3 = new Produktgruppe("fustage","klosterbryg",20,0,775,200,0,"");
		
		//registrer Anlæg
		//String produktNavn, double pris, boolean afleveret, double brugtFustagemængde, double brugtKulsyremængde
		Anlæg a1 = new Anlæg("1-hane",250,true, 100, 0);
		a1.addProduktgruppe(p3);
		System.out.println(a1.beregnPris());

		Anlæg a2 = new Anlæg("1-hane",250,false, 100, 0);
		System.out.println(a2.beregnPris());
		
		//registrer Rundvisning
		Kunde k1 = new Kunde("Bo",true);
		Rundvisning r1 = new Rundvisning(100,150,0.75);
		
		r1.addKunde(k1);
		
		
		//tilføj til Salg
		Salg s = new Salg(1);
		
		s.addProduktgruppe(p1);
		s.addProduktgruppe(p2);
		s.addProduktgruppe(p3);
		
		s.addAnlægEnheder(a1);
		s.addAnlægEnheder(a2);
		
		s.addRundvisning(r1);
		
		//beregn samlet pris
		System.out.println(s.beregnSamletPris());
	}

}

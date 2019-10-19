package nyArkitektur;

import java.time.DayOfWeek;

public class Main {

	public static void main(String[] args) {

		//String kategori, String produktNavn, double pris, double mængde
		Produkt p3 = new Fustage("fustage","klosterbryg",775,20);
		
		//registrer Anlæg
		//String produktNavn, double pris, boolean afleveret, double brugtFustagemængde, double brugtKulsyremængde
		Produkt a1 = new Anlæg("anlæg","1-hane", 250,true, 100, 0);
		((Anlæg) a1).addProdukt(p3);

		//tilføj til Salg
		Salg s = new Salg(1);
		s.addProdukt(a1);
		
		System.out.println(s.beregnSamletPris());
	}

}

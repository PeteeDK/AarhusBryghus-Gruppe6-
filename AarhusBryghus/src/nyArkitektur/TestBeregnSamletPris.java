package nyArkitektur;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import controller.Controller;

public class TestBeregnSamletPris {

	public static void main(String[] args) {

		
		//----Registrer anlæg-------------------------------------------------------------------
		
		//String kategori, String produktNavn, double liter, double butiksPris, double pant
		Produkt f = Controller.createFustage("fustage","klosterbryg",20,775,200);
		//String kategori, String produktNavn, double kg, double fredagsbarPris, double butiksPris, double pant
		Produkt k = Controller.createKulsyre("kulsyre","",6,400,400,1000);
	
		//String kategori, String produktNavn, boolean afleveret, double brugtFustagemængde,
		//double brugtKulsyremængde, double anlægsPris
		Produkt a1 = Controller.createAnlæg("anlæg","1-hane", true, 100, 6, 250);
		((Anlæg) a1).addProdukt(f);
		((Anlæg) a1).addProdukt(k);
		
		Salgssituation ss1 = new Salgssituation();
		Betalingsform b = new Dankort(); 
		
		Salg s1 = Controller.createSalg(ss1,b);
		s1.addProdukt(a1);
		
		System.out.println(s1.beregnSamletPris());
		
		
		
		//------Registrer rundvisninger------------------------------------------------------
		
		Kunde k1 = new Kunde("Bo",true);
		Kunde k2 = new Kunde("Lars",false);
		
		//String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt, double aftenPris,
		//double dagsPris, double studierabat
		Produkt r1 = Controller.createRundvisning("Rundvisnig","Rundvining 1", LocalDate.now(), LocalTime.of(12, 00), 100, 80, 0.9);
		
		((Rundvisning)r1).addKunde(k1);
		((Rundvisning)r1).addKunde(k2);
		
		System.out.println("\nRegistrer rundvisning:\n"+r1.getPris());
		
		((Rundvisning)r1).setBetalt(true, LocalDate.now().plusDays(1));
		
		//Husk at kald beregnPris() før den udregner prisen
		System.out.println(((Rundvisning)r1).beregnPris());

		Salgssituation ss2 = new Salgssituation();
		Betalingsform b2 = new MobilePay();
		
		Salg s2 = Controller.createSalg(ss2, b2);
		
		s2.addProdukt(r1);
		
		System.out.println(s2.beregnSamletPris());
		

				
		//--------Registrer produkter-------------------------------------------------------------
		
		System.out.println("\nRegistrer produkter:");
		//String kategori, String produktNavn, double fredagsbarPris, double butiksPris
		Produkt p1 = Controller.createFlaske("flaske","klosterbryg",50,36);
		//String kategori, String produktNavn, double ølstørrelse, double fredagsbarPris
		Produkt p2 = Controller.createFadøl("fadøl","jazz classic",40,30);
		//String kategori, String produktNavn, double butiksPris, double fredagsbarPris
		Produkt p3 = Controller.createSpiritus("spiritus","Spirit of Aarhus",300,300);
		//String kategori, String produktNavn, double liter, double butiksPris, double pant
		Produkt p4 = Controller.createFustage("fustage","Extra Pilsner", 25, 575, 200);
		//String kategori, String produktNavn, double kg, double fredagsbarPris, double butiksPris, double pant
		Produkt p5 = Controller.createKulsyre("kulsyre","",6,400,400,1000);
		//String kategori, String produktNavn, double kg, double butiksPris
		Produkt p6 = Controller.createMalt("malt","",25,300);
		//String kategori, String produktNavn, double fredagsbarPris, double butiksPris
		Produkt p7 = Controller.createBeklædning("beklædning","t-shirt",70,70);
		//String kategori, String produktNavn, double butiksPris
		Produkt p8 = Controller.createGlas("glas","\"uanset størrelse\"",15);
		//String kategori, String produktNavn, int antalØl, int antalGlas, double fredagsbarPris, double butiksPris
		Produkt p9 = Controller.createSampakning("sampakninger","gaveæske",2,2,100,100);
		
		Salgssituation ss3 = new Salgssituation();
		Betalingsform b3 = new Kontant();
		
		Salg s3 = Controller.createSalg(ss3, b3);
		s3.addProdukt(p1);
		s3.addProdukt(p2);
		s3.addProdukt(p3);
		s3.addProdukt(p4);
		s3.addProdukt(p5);
		s3.addProdukt(p6);
		s3.addProdukt(p7);
		s3.addProdukt(p8);
		s3.addProdukt(p9);
		
		s3.beregnSamletPris();
		
		s3.setSalgsdato(LocalDate.now());
		
		System.out.println(s3.getSamletPris());
		
		
		System.out.println("\nOversigt over dagens salg");
		
		s1.setSalgsdato(LocalDate.now().minusDays(1));
		
		for(Salg s : Controller.getSalgsEnheder()) {
			if(s.getSalgsdato().equals(LocalDate.now())) {
				System.out.println(s.toString());
			}
		}
		 
		
	}

}

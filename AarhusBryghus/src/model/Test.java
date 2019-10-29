package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.*;
import model.rabat.*;
import model.produkter.*;
import storage.Storage;

public class Test {

	public static void main(String[] args) {
		testOpretSalg();
		testOpretSalgLejeAnlæg();
		testOpretSalgRundvisning();
		testBeregnSamletPrisForSalg();
		testKlippekortSomProduktOgBetalingsform();
		testVisDagensSalg();
		testVisSolgteKlippekortForEnGivenPeriodeSamtBrugteKlip();
	}


	private static void testOpretSalg() {
	
		//--- 5 klosterbryg i fredagsbar til 50 kr. med og uden rabat -----------------------------------
		
		//lav et Produkt fx. flaskeøl
		Flaske flaske = Controller.createFlaske("flaske","klosterbryg");
		
		//lav en Pris på flaskeøl i PrisListe fx. 50 kr
		PrisListe prisliste = Controller.createPrisliste("fredagsbar");
		Pris pris = prisliste.createPris(flaske, 50);
		
		//brug prisen til at lave en Produktlinje i Salg fx. 5 klosterbryg med pris 50 kr. 
		Salg salg = Controller.createSalg();
		ProduktLinje produktLinje = salg.createProduktLinje(pris, 5);
		
		//beregn prisen uden rabat - 250 kr.
		System.out.println("5 klosterbryg i fredagsbar til 50 kr.:\n"+salg.getPris());
		
		//beregn prisen med procentvis rabat fx. 10% - lav objekt af ProcentvisRabat og tilføj til produktlinjen - 225 kr.
		Rabat rabat = Controller.createProcentvisRabat(10);
		salg.setRabat(rabat);
		
		System.out.println("\n5 klosterbryg i fredagsbar til 50 kr. med 10% rabat:\n"+salg.getPris());
		
		System.out.println("\n---------------------------------------------------------------\n");
		
		
	}

	
	private static void testOpretSalgLejeAnlæg() {
		
		//--- Leje af et anlæg ... -----------------------------------

		//1.del - beregn pris af anlæg uden tilbehør
		
		//lav et Anlæg - 1-hane
		Anlæg anlæg = Controller.createAnlæg("anlæg","1-hane");
		
		//lav en Pris for anlæg i Prisklasse - 250 kr.
		PrisListe prisliste1 = Controller.createPrisliste("butik");
		Pris pris1 = prisliste1.createPris(anlæg, 250);
		
		//brug prisen til at oprette ProduktLinje i Salg - 1 stk., prisen
		Salg s1 = Controller.createSalg();
		ProduktLinje produktlinje1 = s1.createProduktLinje(pris1, 1);
		
		//Tilføj til salget
		s1.addProduktLinje(produktlinje1);
		
		//beregn prisen i produktlinje - 250 kr.
		System.out.println("\n1 anlæg uden tilbehør:\n"+s1.getPris());

		
		//2.del - beregn pris af anlæg med tilbehør uden forbrug (beregning af pant)
		
		//lav en fustage - klosterbryg, 20, 200 kr. (pant)
		Fustage fustage = Controller.createFustage("fustage","klosterbryg",20, 200);
		
		//lav en kulsyre - 6 kg, 1000 kr. (pant)
		Kulsyre kulsyre = Controller.createKulsyre("kulsyre","",6, 1000);
		
		//lav en pris i Prisklasse til fustagen - 775/20 (pris pr. liter)
		PrisListe prisliste2 = Controller.createPrisliste("butik");
		Pris pris2 = prisliste2.createPris(fustage, (775.0/20));
		
		//lav en pris i Prisklasse til kulsyren - 400/6 (pris pr. kg)
		Pris pris3 = prisliste2.createPris(kulsyre, (400.0/6));
		
		//tilføj priserne på fustagen og kulsyren til anlæg fra 1.del
		anlæg.addTilbehør(pris2);
		anlæg.addTilbehør(pris3);
		
		//lav en produktlinje i Salg - anlægget og 1 stk.
		Salg s2 = Controller.createSalg();
		ProduktLinje produktlinje2 = s2.createProduktLinje(pris1, 1);
		
		//tilføj produktlinje til salget
		s2.addProduktLinje(produktlinje2);
		
		//beregn prisen i produktlinjen - 250 + 200 + 1000 = 1450
		System.out.println("\nAnlæg med tilbehør(1 fustage og 1 kulsyre): 1450\n"+s2.getPris());
		
		
		//3.del - beregn pris af anlæg med tilbehør med forbrug 
		
		//det er vigtigt at tilbehør er tilføjet 
		
		//set brugtFustagemængde til anlæg fra 1.del og 2.del - 10 - (pris = 10 * (775/20) = 387,5)
		anlæg.setBrugtFustagemængde(10);
		
		//set brugtKulsyremængde til anlæg fra 1.del og 2.del - 4 - (pris = 4 * (400/6) = 266,67)
		anlæg.setBrugtKulsyremængde(4);
		
		//set afleveret til anlæg - true
		anlæg.setAfleveret(true);
		
		//lav en produktlinje i salg - anlægget og 1 stk.
		Salg s3 = Controller.createSalg();
		ProduktLinje produktlinje3 = s3.createProduktLinje(pris1,1);
		
		//Tilføj produktlinje til salget
		s3.addProduktLinje(produktlinje3);
		
		//beregn prisen i produktlinjen - 387,5 + 266,67 + 250 - 1200(pant) = -295,83	TODO kig på decimaler i Pris
		System.out.println("\nForbrug(fustage og kulsyre) + anlæg - pant: (387,5 + 266,67) + 250 - 1200 = -295,83\n"+s3.getPris());

		System.out.println("\n---------------------------------------------------------------\n");

	}
	

	private static void testOpretSalgRundvisning() {
		
		//1.del - rundvisning, 10 personer, 100 kr. pr. person, uden studierabat
		
		//lav en rundvisning - LocalDate.of(24/10), LocalTime.of(12:00)
		Rundvisning rundvisning1 = Controller.createRundvisning("Rundvisning","19V",LocalDate.of(2019, 10, 24), LocalTime.of(12, 00));
		
		//lav en pris i Prisliste med rundvisningen - pris: 100
		PrisListe prisliste1 = Controller.createPrisliste("Butik");
		Pris pris1 = prisliste1.createPris(rundvisning1, 100);
		
		//lav en produktlinje i Salg med rundvisningen - antal: 10 stk.
		Salg s1 = Controller.createSalg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1, 10);
		
		//beregn pris i produktlinje, ikke betalt - 0
		System.out.println("\nRundvisning er ikke sat til betalt: 0\n"+produktlinje1.getPris());
		
		//set rundvisning til betalt samme dag - true, localDate.of(2019,10,24)
		rundvisning1.setBetalt(true, LocalDate.of(2019, 10, 24));
		
		//rundvisning stadig ikke betalt - 0
		System.out.println("\nRundvisning er sat til betalt samme dag. Stadig ikke betalt: 0\n"+produktlinje1.getPris());
		
		//set rundvisning til betalt én dag efter rundvisningsdatoen - true, localDate.of(2019,10,25)
		rundvisning1.setBetalt(true, LocalDate.of(2019, 10, 25));
		System.out.println("\nRundvisning sat til betalt én dag efter rundvisningsdatoen...");
		
		//Tilføj produktlinje til salget
		s1.addProduktLinje(produktlinje1);
		
		//beregn pris i produktlinje - 1000
		System.out.println("\nRundvisning, 10 personer, 100 kr. pr. person, uden studierabat - 1000 kr.:\n"+s1.getPris());
		
		
		//2.del - rundvisning, 10 personer, 100 kr. pr. person, med studierabat til 9 af dem
		
		//lav en studierabat til 9 af personerne på 10%
		Rabat rabat1 = Controller.createStudieRabat(produktlinje1,9,10);
		
		//set rabat i salget fra 1.del
		s1.setRabat(rabat1);

		
		//beregn pris i produktlinje - 910
		System.out.println("\nRundvisning, 10 personer, 100 kr. pr. person, med studierabat til 9 af dem på 10% - 910:\n"+s1.getPris());
		
		System.out.println("\n---------------------------------------------------------------\n");
		
	}


	private static void testBeregnSamletPrisForSalg() {
		
		//opret tre forskellige produkter af flaskeøl
		Flaske flaske1 = Controller.createFlaske("flaske", "klosterbryg");
		Flaske flaske2 = Controller.createFlaske("flaske", "Sweet Georgia Brown");
		Flaske flaske3 = Controller.createFlaske("flaske", "Extra Pilsner");
		
		
		//opret tre forskellige priser til de tre forskellige produkter af flaske i en Prisliste
		PrisListe prisliste1 = Controller.createPrisliste("Butik");
		Pris pris1 = prisliste1.createPris(flaske1, 36);
		Pris pris2 = prisliste1.createPris(flaske2, 36);
		Pris pris3 = prisliste1.createPris(flaske3, 36);
		
		//lav et Salg der opretter 3 produktlinjer med hver deres pris
		Salg s1 = Controller.createSalg();
		ProduktLinje produktlinje1 = s1.createProduktLinje(pris1, 1);
		ProduktLinje produktlinje2 = s1.createProduktLinje(pris2, 1);
		ProduktLinje produktlinje3 = s1.createProduktLinje(pris3, 1);
		
		//kør beregnSamletPris() i salget - 3 x 36 = 108
		System.out.println("Et salg med opretter tre produktlinjer hver med 1 flaske til 36, 3 x 36 = 108\n"+s1.getPris());
	
		System.out.println("\n---------------------------------------------------------------\n");

		
	}
	

	private static void testKlippekortSomProduktOgBetalingsform() {

		//opret et klippekort som produkt
		Produkt produkt1 = Controller.createKlippekort("klipppekort", "klippekort, 4 klip");
		
		//lav en pris til klippekort i PrisListe - 100 kr
		PrisListe prisliste1 = Controller.createPrisliste("Fredagsbar");
		Pris pris1 = prisliste1.createPris(produkt1, 100);
		
		//lav en produktlinje i Salg med prisen - 1 stk
		Salg salg1 = Controller.createSalg();
		ProduktLinje produktlinje1 = salg1.createProduktLinje(pris1, 1);
		
		//beregn samlet pris for salget
		System.out.println("Samlet pris for klippekort i Salg:\n"+salg1.getPris());
		
		//opret klippekort som betalingsform
		Betalingsform betalingsform1 = Controller.createBetalingsform();
		betalingsform1.setBetalingsform((IBetalingsform)produkt1);
		
		//tilføj betalingsformen til salget
		salg1.setBetalingsform(betalingsform1);
		
		//udskriv betalingsform for salget
		System.out.println("\nBetalt med klippekort for køb af klippekort:\n"+salg1.getBetalingsform().registrerBetaling());
		
		System.out.println("\nHver gang der registreres betaling med klippekortet bliver et klip brugt:");
		for(int i = 0; i < 4; i++) {
			System.out.println(salg1.getBetalingsform().registrerBetaling());
		}

		System.out.println("\n---------------------------------------------------------------\n");

		
	}
	

	private static void testVisDagensSalg() {

		//lav et salg og set salgdato til d.23.10.2019
		Salg s1 = Controller.createSalg();
		s1.setSalgsdato(LocalDate.of(2019, 10, 23));
		
		//udskriv oversigt over alle salg gemt i storage
		System.out.println("Alle salg gemt i storage:\n");
		for(Salg s : Controller.getSalgsEnheder()) {
			System.out.println("SalgID: "+s.getId()+ ", dato: "+s.getSalgsdato());
		}
		
		//udskriv alle salg med dato den 23.10.2019
		System.out.println("\nAlle salg d.23/10/2019 - 1 salg:");
		for(Salg s : Controller.getSalgsEnheder()) {
			if(s.getSalgsdato().equals(LocalDate.of(2019, 10, 23)))
			System.out.println("SalgID: "+s.getId()+ ", dato: "+s.getSalgsdato());
		}

		System.out.println("\n---------------------------------------------------------------\n");
		
	}
	
	private static void testVisSolgteKlippekortForEnGivenPeriodeSamtBrugteKlip() {
		
		//1.del
		
		//opret 3 Klippekort som produkt med en uges interval
		Klippekort klippekort1 = Controller.createKlippekort("Klippekort", "klippekort1");
		klippekort1.setKøbsdato(LocalDate.of(2019, 10, 1));
		Klippekort klippekort2 = Controller.createKlippekort("Klippekort", "klippekort2");
		klippekort2.setKøbsdato(LocalDate.of(2019, 10, 8));
		Klippekort klippekort3 = Controller.createKlippekort("Klippekort", "klippekort3");
		klippekort3.setKøbsdato(LocalDate.of(2019, 10, 15));
		
		System.out.println("Alle klippekort der er udstedt - 3 stk.:");
		//vis alle klippekort i storage for produkt
		for(Produkt k : Controller.getKlippekortEnheder()) {
			System.out.println(k + ", købsdato: " + ((Klippekort)k).getKøbsdato());
		}
		
		System.out.println("\nAlle klippekort udstedt mellem den 30/9 - 9/10 - 2 stk.:");
		//vis klippekort der er udsted for en to uger lang periode
		for(Produkt k : Controller.getKlippekortEnheder()) {
			if(((Klippekort)k).getKøbsdato().isAfter(LocalDate.of(2019, 9, 30)) && ((Klippekort)k).getKøbsdato().isBefore(LocalDate.of(2019, 10, 9))) {
				System.out.println(k + ", købsdato: " + ((Klippekort)k).getKøbsdato());
			}
		}
		
		System.out.println("\nAlle brugte klip mellem 30/9-9/10:");
		
		//2.del
		
		//registrer 3 klip for klippekort1
		for(int i = 0 ; i < 3; i++) {
			klippekort1.getKlipEnheder().get(i).setBrugt(true);
			klippekort1.getKlipEnheder().get(i).setTransaktionsdato(klippekort1.getKøbsdato());
		}
		

		//registrer 2 klip for klippekort2
		for(int i = 0 ; i < 2; i++) {
			klippekort2.getKlipEnheder().get(i).setBrugt(true);
			klippekort2.getKlipEnheder().get(i).setTransaktionsdato(klippekort2.getKøbsdato());
		}
		
		//registrer 3 klip for klippekort2
		for(int i = 0 ; i < 4; i++) {
			klippekort3.getKlipEnheder().get(i).setBrugt(true);
			klippekort3.getKlipEnheder().get(i).setTransaktionsdato(klippekort3.getKøbsdato());
		}
		
		//vis alle klip der er brugt mellem d. 30/9 - 9/10 - 5 stk
		for(Produkt klippekort : Controller.getKlippekortEnheder()) {
			for(Klip k : ((Klippekort)klippekort).getKlipEnheder()) {
				if(k.isBrugt()) {
					if(k.getTransaktionsdato().isAfter(LocalDate.of(2019, 9, 30)) && k.getTransaktionsdato().isBefore(LocalDate.of(2019, 10, 9))) {
						System.out.println(klippekort.getProduktNavn() + ", " + k.getNr() + ", købsdato: " + k.getTransaktionsdato());
					}
				}
			}
		}
		
		System.out.println("\n---------------------------------------------------------------\n");
		
	}


	
}













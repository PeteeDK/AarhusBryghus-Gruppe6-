package model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.betalingsform.Dankort;
import model.produkter.Fadøl;
import model.produkter.Flaske;
import model.produkter.Glas;
import model.produkter.Malt;
import model.produkter.Sampakninger;
import model.produkter.Spiritus;
import model.rabat.AftaltPrisRabat;
import model.rabat.ProcentvisRabat;
import model.rabat.StudieRabat;

public class UnitTests {
	
	@Test
	public void testProdukt() {
		Produkt p1 = new Produkt(" FlasKe ", " KlosterBRyG ");
		assertEquals("flaske",p1.getKategori());
		assertEquals("klosterbryg",p1.getProduktNavn());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrisListe1() {
		Produkt p1 = new Produkt("flaske", "klosterbryg");
		PrisListe prisliste1 = new PrisListe("arrangement");
		Pris pris1 = prisliste1.createPris(null, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrisListe2() {
		Produkt p1 = new Produkt("flaske", "klosterbryg");
		PrisListe prisliste1 = new PrisListe("arrangement");
		Pris pris2 = prisliste1.createPris(p1, -1);
		Pris pris3 = prisliste1.createPris(p1, 0);
	}

	@Test
	public void testPrisListe3() {
		Produkt p1 = new Produkt("flaske", "klosterbryg");
		PrisListe prisliste1 = new PrisListe("arrangement");
		Pris pris3 = prisliste1.createPris(p1, 36);
		assertEquals(pris3.getProdukt(),p1);
		assertEquals(pris3.getPris(),36,2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPris1() {
		Produkt p1 = new Produkt("flaske", "klosterbryg");
		Pris pris1 = new Pris(null, 0);
	}	

	@Test(expected=IllegalArgumentException.class)
	public void testPris2() {
		Produkt p1 = new Produkt("flaske", "klosterbryg");
		Pris pris2 = new Pris(p1, -1);
	}	
	
	@Test
	public void testPris3() {
		Produkt p1 = new Produkt("flaske", "klosterbryg");
		Pris pris3 = new Pris(p1, 0);
		assertEquals(p1,pris3.getProdukt());
		assertEquals(0,pris3.getPris(),2);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testAnlæg1() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		anlæg1.setBrugtFustagemængde(-1);
	}	 
	
	@Test(expected=ArithmeticException.class)
	public void testAnlæg2() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		anlæg1.setBrugtFustagemængde(20.1);
	}	

	@Test
	public void testAnlæg3() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		anlæg1.setBrugtFustagemængde(20);
		assertEquals(anlæg1.getBrugtFustagemængde(),20,2);
	}	 
	
	@Test(expected=IllegalArgumentException.class)
	public void testAnlæg4() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		anlæg1.setBrugtKulsyremængde(-1);
	}	 

	@Test(expected=ArithmeticException.class)
	public void testAnlæg5() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		anlæg1.setBrugtKulsyremængde(6.1);
	}	 

	
	@Test
	public void testAnlæg6() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		anlæg1.setBrugtKulsyremængde(6);
		assertEquals(anlæg1.getBrugtKulsyremængde(),6,1);
	}	 

	
	@Test
	public void testAnlæg7() {
		Tilbehør produkt1 = new Tilbehør("fustage", "klosterbryg", 20);
		Tilbehør produkt2 = new Tilbehør("kulsyre", "", 6);
		Pris pris1 = new Pris(produkt1,(775.0/20));
		Pris pris2 = new Pris(produkt2,(400.0/6));
		Anlæg anlæg1 = new Anlæg("anlæg","1-hane");
		anlæg1.addTilbehør(pris1);
		anlæg1.addTilbehør(pris2);
		assertEquals(anlæg1.beregnForbrug(),1200,2);
		anlæg1.setBrugtFustagemængde(20);
		anlæg1.setBrugtKulsyremængde(6);
		anlæg1.setAfleveret(true);
		assertEquals(Math.round(anlæg1.beregnForbrug()),-25,2);	//Det eksakte beløb af beregn forbrug er 24,98
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testProduktLinje1() {
		Pris pris1 = null;
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testProduktLinje2() {
		Produkt produkt1 = new Produkt("flaske", "klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testProduktLinje3() {
		Produkt produkt1 = new Produkt("flaske", "klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,0);
		assertEquals(produktlinje1.getPrisObj(),pris1);
		assertEquals(produktlinje1.getAntal(),0);
	}
	
	@Test
	public void testProduktLinje4() {
		Produkt produkt1 = new Produkt("flaske", "klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		assertEquals(produktlinje1.getPris(),36,2);
	}
	
	@Test
	public void testProduktLinje5() {
		Anlæg anlæg1 = new Anlæg("anlæg", "1-hane");
		Pris pris1 = new Pris(anlæg1,250);
		Tilbehør tilbehør1 = new Tilbehør("fustage","klosterbryg",20);
		Tilbehør tilbehør2 = new Tilbehør("kulsyre","",6);
		Pris pris2 = new Pris(tilbehør1, 775.0/20);
		Pris pris3 = new Pris(tilbehør2, 400.0/6);
		((Anlæg) anlæg1).addTilbehør(pris2);
		((Anlæg) anlæg1).addTilbehør(pris3);
		((Anlæg) anlæg1).setAfleveret(false);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		assertEquals(produktlinje1.getPris(),1450,2);
		((Anlæg) anlæg1).setAfleveret(true);
		assertEquals(produktlinje1.getPris(),-1200,2);
	}
	
	@Test
	public void testProduktLinje6() {
		Rundvisning rundvisning1 = new Rundvisning("rundvisning", "");
		Pris pris1 = new Pris(rundvisning1,100);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		assertEquals(produktlinje1.getPris(),0,2);
		rundvisning1.setDato(LocalDate.now());
		rundvisning1.setBetalt(true, LocalDate.now().plusDays(1));
		assertEquals(produktlinje1.getPris(),100,2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testProcentvisRabat1() {
		ProcentvisRabat pr = new ProcentvisRabat(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testProcentvisRabat2() {
		ProcentvisRabat pr = new ProcentvisRabat(101);
	}

	@Test
	public void testProcentvisRabat3() {
		ProcentvisRabat pr = new ProcentvisRabat(0);
		assertEquals(pr.getProcent(),0,2);
		pr.setProcent(5);
		assertEquals(pr.tildelRabat(100),95,2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAftaltPris1() {
		AftaltPrisRabat pr = new AftaltPrisRabat(100);
		pr.tildelRabat(99);
	}
	
	@Test
	public void testAftaltPris2() {
		AftaltPrisRabat pr = new AftaltPrisRabat(100);
		assertEquals(pr.tildelRabat(100),0,2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testStudieRabat1() {
		ProduktLinje produktlinje1 = null;
		StudieRabat sr = new StudieRabat(null,0,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testStudieRabat2() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		StudieRabat sr = new StudieRabat(produktlinje1,-1,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testStudieRabat3() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		StudieRabat sr = new StudieRabat(produktlinje1,0,-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testStudieRabat4() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		StudieRabat sr = new StudieRabat(produktlinje1,0,101);
	}
	
	@Test
	public void testStudieRabat5() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		StudieRabat sr = new StudieRabat(produktlinje1,0,0);
		assertEquals(sr.getProduktlinje(),produktlinje1);
		assertEquals(sr.getAntalStuderende(),0);
		assertEquals(sr.getRabatProcent(),0,2);
	}
	
	@Test
	public void testSalg1() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		ProduktLinje produktlinje2 = new ProduktLinje(pris1,1);
		ProduktLinje produktlinje3 = new ProduktLinje(pris1,1);
		Salg salg1 = new Salg();
		salg1.addProduktLinje(produktlinje1);
		salg1.addProduktLinje(produktlinje2);
		salg1.addProduktLinje(produktlinje3);
		assertEquals(salg1.getPris(),108,2);
		AftaltPrisRabat ar = new AftaltPrisRabat(10);
		salg1.setRabat(ar);
		assertEquals(salg1.getPris(),98,2);
		ProcentvisRabat pr = new ProcentvisRabat(50);
		salg1.setRabat(pr);
		assertEquals(salg1.getPris(),54,2);
	}
	
	@Test
	public void testSalg2() {
		Rundvisning rundvisning1 = new Rundvisning("rundvisning","");
		Pris pris1 = new Pris(rundvisning1,100);
		rundvisning1.setDato(LocalDate.now());
		rundvisning1.setBetalt(true, LocalDate.now().plusDays(1));
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,10);
		StudieRabat sr = new StudieRabat(produktlinje1, 9, 20);
		produktlinje1.setStudieRabat(sr);
		Salg salg1 = new Salg();
		salg1.addProduktLinje(produktlinje1);
		assertEquals(salg1.getPris(),820,2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSalg3() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		salg1.createProduktLinje(pris1, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSalg4() {
		Salg salg1 = new Salg();
		salg1.createProduktLinje(null, 0);
	}
	
	public void testSalg5() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje = salg1.createProduktLinje(pris1, 0);
		assertEquals(produktlinje.getPrisObj(),pris1);
		assertEquals(produktlinje.getPris(),36,2);
		assertEquals(salg1.getProduktLinjer().size(),1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSalg6() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = null;
		salg1.addProduktLinje(produktlinje1);
	}
	
	@Test
	public void testSalg7() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		salg1.addProduktLinje(produktlinje1);
		assertEquals(salg1.getProduktLinjer().size(),1);
		salg1.addProduktLinje(produktlinje1);				
		assertEquals(salg1.getProduktLinjer().size(),1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSalg8() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		salg1.addProduktLinje(produktlinje1);
		salg1.getPris();
		Dankort betalingsform1 = null;
		salg1.betaling(betalingsform1, 36);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSalg9() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		salg1.addProduktLinje(produktlinje1);
		salg1.getPris();
		Dankort betalingsform1 = new Dankort();
		salg1.betaling(betalingsform1, -1);
	}

	@Test
	public void testSalg10() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		salg1.addProduktLinje(produktlinje1);
		salg1.getPris();
		Dankort betalingsform1 = new Dankort();
		salg1.betaling(betalingsform1, 35);
		assertEquals(salg1.getFuldBeløb(),1,2);
		assertEquals(salg1.getErBetalt(),false);
	}
	
	@Test
	public void testSalg11() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		salg1.addProduktLinje(produktlinje1);
		salg1.getPris();
		Dankort betalingsform1 = new Dankort();
		salg1.betaling(betalingsform1, 36);
		assertEquals(salg1.getFuldBeløb(),1,2);
		assertEquals(salg1.getErBetalt(),true);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testSalg12() {
		Produkt produkt1 = new Produkt("flaske","klosterbryg");
		Pris pris1 = new Pris(produkt1,36);
		Salg salg1 = new Salg();
		ProduktLinje produktlinje1 = new ProduktLinje(pris1,1);
		salg1.addProduktLinje(produktlinje1);
		salg1.getPris();
		Dankort betalingsform1 = new Dankort();
		salg1.betaling(betalingsform1, 37);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTilbehør1() {
		Tilbehør produkt1 = new Tilbehør("fustage","klosterbryg",-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTilbehør2() {
		Tilbehør produkt1 = new Tilbehør("fustage","klosterbryg",0);
		produkt1.setPant(-1);
	}
	
	@Test
	public void testKlippekort1() {
		Klippekort klippekort1 = new Klippekort("klippekort" , "");
		assertEquals(klippekort1.getAntalKlip(),4,2);
		assertEquals(klippekort1.getId(),1,2);
	}
	
	@Test
	public void testKlippekort2() {
		Klippekort klippekort1 = new Klippekort("klippekort" , "");
		klippekort1.registrerBetaling();
		int brugt = 0;
		ArrayList<Klip> brugteKlip = new ArrayList<>();
		for(Klip k : klippekort1.getKlipEnheder()) {
			if(k.isBrugt()) {
				brugteKlip.add(k);
			}
		}
		brugt = brugteKlip.size();
		assertEquals(brugt,1,2);
		assertEquals(klippekort1.antalKlipTilbage(),3);
		assertEquals(klippekort1.isOpbrugt(),false);
	}

	@Test
	public void testKlippekort3() {
		Klippekort klippekort1 = new Klippekort("klippekort" , "");
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();

		int brugt = 0;
		ArrayList<Klip> brugteKlip = new ArrayList<>();
		for(Klip k : klippekort1.getKlipEnheder()) {
			if(k.isBrugt()) {
				brugteKlip.add(k);
			}
		}
		brugt = brugteKlip.size();
		assertEquals(brugt,4,2);
		assertEquals(klippekort1.isOpbrugt(),true);
	}

	
	@Test(expected=RuntimeException.class)
	public void testKlippekort4() {
		Klippekort klippekort1 = new Klippekort("klippekort" , "");
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();
		klippekort1.registrerBetaling();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFadøl1() {
		Fadøl fadøl1 = new Fadøl("fadøl","klosterbryg");
		fadøl1.setØlstørrelse(-1);
	}
	
	@Test
	public void testFadøl2() {
		Fadøl fadøl1 = new Fadøl("fadøl","klosterbryg");
		fadøl1.setØlstørrelse(0);
		assertEquals(fadøl1.getØlstørrelse(),0,2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFlaske1() {
		Flaske flaske1 = new Flaske("flaske","klosterbryg");
		flaske1.setFlaskeStørrelse(-1);
	}

	@Test
	public void testFlaske2() {
		Flaske flaske1 = new Flaske("flaske","klosterbryg");
		flaske1.setFlaskeStørrelse(0);
		assertEquals(flaske1.getFlaskeStørrelse(),0,2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMalt1() {
		Malt malt1 = new Malt("malt","");
		malt1.setMængde(-1);
	}

	@Test
	public void testMalt2() {
		Malt malt1 = new Malt("malt","");
		malt1.setMængde(0);
		assertEquals(malt1.getMængde(),0,2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSampakninger1() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		sampakninger1.setAntalGlas(-1);
	}

	@Test
	public void testSampakninger2() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		sampakninger1.setAntalGlas(0);
		assertEquals(sampakninger1.getAntalGlas(),0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSampakninger3() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		sampakninger1.setAntalØl(-1);
	}
	
	@Test
	public void testSampakninger4() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		sampakninger1.setAntalØl(0);
		assertEquals(sampakninger1.getAntalØl(),0);
	}
	
	@Test
	public void testSampakninger5() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		Spiritus spirutus = new Spiritus("spiritus","spirit of aarhus");
		sampakninger1.addIndhold(spirutus);
		assertEquals(sampakninger1.getAntalØl(),2);
		assertEquals(sampakninger1.getAntalGlas(),2);
	}
	
	@Test
	public void testSampakninger6() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		Flaske flaske1 = new Flaske("flaske","klosterbryg");
		sampakninger1.addIndhold(flaske1);
		assertEquals(sampakninger1.getAntalØl(),1);
		assertEquals(sampakninger1.getAntalGlas(),2);
	}

	@Test
	public void testSampakninger7() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		Glas glas1 = new Glas("glas","");
		sampakninger1.addIndhold(glas1);
		assertEquals(sampakninger1.getAntalØl(),2);
		assertEquals(sampakninger1.getAntalGlas(),1);
	}

	@Test
	public void testSampakninger8() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		Flaske flaske1 = new Flaske("flaske","klosterbryg");
		Flaske flaske2 = new Flaske("flaske","indian pale ale");
		Glas glas1 = new Glas("glas","");
		Glas glas2 = new Glas("glas","");
		sampakninger1.addIndhold(flaske1);
		sampakninger1.addIndhold(flaske2);
		sampakninger1.addIndhold(glas1);
		sampakninger1.addIndhold(glas2);
		sampakninger1.removeIndhold(flaske1);
		assertEquals(sampakninger1.getAntalØl(),1);
		assertEquals(sampakninger1.getAntalGlas(),0);
	}
	
	@Test
	public void testSampakninger9() {
		Sampakninger sampakninger1 = new Sampakninger("sampakninger","gaveæske 2 øl, 2 glas", 2, 2);
		Flaske flaske1 = new Flaske("flaske","klosterbryg");
		Flaske flaske2 = new Flaske("flaske","indian pale ale");
		Glas glas1 = new Glas("glas","");
		Glas glas2 = new Glas("glas","");
		sampakninger1.addIndhold(flaske1);
		sampakninger1.addIndhold(flaske2);
		sampakninger1.addIndhold(glas1);
		sampakninger1.addIndhold(glas2);
		sampakninger1.removeIndhold(glas1);
		assertEquals(sampakninger1.getAntalØl(),0);
		assertEquals(sampakninger1.getAntalGlas(),1);
	}

	
	
	
}

package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import nyArkitektur.*;
import storage.Storage;

public class Controller {

//	private static Salgssituation salgssituaion;
	

	/**
	 * 	Generisk delete-funktion af produkter
	 */
	
	//delete (generisk funktion for alle produkter) TODO Test om det virker på alle produktkategorierne
    public static void deleteProdukt(Produkt produkt) {
        Storage.removeProdukt(produkt);
    }
	

	/**
	 * 	Registrer produkter
	 *	create, update, get
	 *	
	 *	Create dækker over at skulle varetage registreringe. update og get er hjælpemetoder til senere hen
	 *	Update kan hjælpe til at give en individuel pris
	 */

    
    
  //-------Flaske---------------------------------------------------
    
    
  	//create
  	public static Produkt createFlaske(String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
  		//TODO Hvad sker der hvis man opretter flere flaske
  		Produkt flaske = new Flaske(kategori, produktNavn, fredagsbarPris, butiksPris);
  		Storage.addProdukt(flaske);
  		return flaske;
  	}
  	
  	//update
      public static void updateFlaske(Flaske flaske, String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
    	  flaske.setKategori(kategori);
    	  flaske.setProduktNavn(produktNavn);
    	  flaske.setFredagsbarPris(fredagsbarPris);
    	  flaske.setButiksPris(butiksPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getFlasker() {
      	ArrayList<Produkt> flasker = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("flaske")) {
      			flasker.add(p);
      		}
      	}
          return flasker;
      }
    
    
      
      
    //-------Fadøl---------------------------------------------------
          
  	//create
  	public static Produkt createFadøl(String kategori, String produktNavn, double ølstørrelse, double fredagsbarPris) {
  		//TODO Lav en fejlhåndtering hvis man prøver at oprette en fadøl på en ikke-fredag
  		if(Salgssituation.isFredagsbarMode()) {
  	  		Produkt fadøl = new Fadøl(kategori, produktNavn, ølstørrelse, fredagsbarPris);
  	  		Storage.addProdukt(fadøl);
  	  		return fadøl;
  		}else {
  			return null;
  		}
  	}
  	
  	//update
      public static void updateFadøl(Fadøl fadøl, String kategori, String produktNavn, double ølstørrelse, double fredagsbarPris) {
    	  fadøl.setKategori(kategori);
    	  fadøl.setProduktNavn(produktNavn);
    	  fadøl.setØlstørrelse(ølstørrelse);
    	  fadøl.setFredagsbarPris(fredagsbarPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getFadølEnheder() {
      	ArrayList<Produkt> fadølEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("fadøl")) {
      			fadølEnheder.add(p);
      		}
      	}
          return fadølEnheder;
      }
 
      
      
    //-------Spiritus---------------------------------------------------
      
      
  	//create
  	public static Produkt createSpiritus(String kategori, String produktNavn, double butiksPris, double fredagsbarPris) {
  		Produkt spiritus = new Spiritus(kategori, produktNavn, butiksPris, fredagsbarPris);
  		Storage.addProdukt(spiritus);
  		return spiritus;
  	}
  	
  	//update
      public static void updateFustage(Spiritus spiritus, String kategori, String produktNavn, double butiksPris, double fredagsbarPris) {
    	  spiritus.setKategori(kategori);
    	  spiritus.setProduktNavn(produktNavn);
    	  spiritus.setButiksPris(butiksPris);
    	  spiritus.setFredagsbarPris(fredagsbarPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getSpiritusEnheder() {
      	ArrayList<Produkt> spiritusEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("spiritus")) {
      			spiritusEnheder.add(p);
      		}
      	}
          return spiritusEnheder;
      }

      
    
      
    //-------Fustage---------------------------------------------------
    
      
	//create
	public static Produkt createFustage(String kategori, String produktNavn, double liter, double butiksPris, double pant) {
		//TODO fejlhåndtering når man prøver at oprette en produkt en fredag
		if(Salgssituation.isFredagsbarMode()) {
			return null;
		}else {
			Produkt fustage = new Fustage(kategori, produktNavn, liter, butiksPris, pant);
			Storage.addProdukt(fustage);
			return fustage;
		}
	}
	
	//update
    public static void updateFustage(Fustage fustage, String kategori, String produktNavn, double liter, double butiksPris, double pant) {
    	fustage.setKategori(kategori);
    	fustage.setProduktNavn(produktNavn);
    	fustage.setLiter(liter);
    	fustage.setButiksPris(butiksPris);
    	fustage.setPant(pant);
    }
	
	//get
    public static ArrayList<Produkt> getFustager() {
    	ArrayList<Produkt> fustager = new ArrayList<>();
    	for(Produkt p : Storage.getProdukter()) {
    		if(p.getKategori().equals("fustage")) {
    			fustager.add(p);
    		}
    	}
        return fustager;
    }

    
    
  //-------Kulsyre---------------------------------------------------
    
    
  	//create
  	public static Produkt createKulsyre(String kategori, String produktNavn, double kg, double fredagsbarPris, double butiksPris,
			double pant) {
  		Produkt kulsyre = new Kulsyre(kategori, produktNavn, kg, fredagsbarPris, butiksPris, pant);
  		Storage.addProdukt(kulsyre);
  		return kulsyre;
  	}
  	
  	//update
      public static void updateKulsyre(Kulsyre kulsyre, String kategori, String produktNavn, double kg, double fredagsbarPris, double butiksPris,
  			double pant) {
      	kulsyre.setKategori(kategori);
      	kulsyre.setProduktNavn(produktNavn);
      	kulsyre.setKg(kg);
      	kulsyre.setFredagsbarPris(fredagsbarPris);
      	kulsyre.setButiksPris(butiksPris);
      	kulsyre.setPant(pant);
      }
  	
  	//get
      public static ArrayList<Produkt> getKulsyreEnheder() {
      	ArrayList<Produkt> kulsyreEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("kulsyre")) {
      			kulsyreEnheder.add(p);
      		}
      	}
          return kulsyreEnheder;
      }

    
      
    //-------Malt---------------------------------------------------
      
      
  	//create
  	public static Produkt createMalt(String kategori, String produktNavn, double kg, double butiksPris) {
  		//TODO Salgssituation kun ikke-fredagsbarMode
  		if(Salgssituation.isFredagsbarMode()) {
  			return null;
  		}else {
  	  		Produkt malt = new Malt(kategori, produktNavn, kg, butiksPris);
  	  		Storage.addProdukt(malt);
  	  		return malt;
  		}
  	}
  	
  	//update
      public static void updateMalt(Malt malt, String kategori, String produktNavn, double kg, double butiksPris) {
    	  malt.setKategori(kategori);
    	  malt.setProduktNavn(produktNavn);
    	  malt.setKg(kg);
    	  malt.setButiksPris(butiksPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getMaltEnheder() {
      	ArrayList<Produkt> maltEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("malt")) {
      			maltEnheder.add(p);
      		}
      	}
          return maltEnheder;
      }

      
      
    //-------Beklædning---------------------------------------------------
      
      
  	//create
  	public static Produkt createBeklædning(String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
  		Produkt beklædning = new Beklædning(kategori, produktNavn, fredagsbarPris, butiksPris);
  		Storage.addProdukt(beklædning);
  		return beklædning;
  	}
  	
  	//update
      public static void updateBeklædning(Beklædning beklædning, String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
      	beklædning.setKategori(kategori);
      	beklædning.setProduktNavn(produktNavn);
      	beklædning.setFredagsbarPris(fredagsbarPris);
      	beklædning.setButiksPris(butiksPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getBeklædninger() {
      	ArrayList<Produkt> beklædninger = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("beklædning")) {
      			beklædninger.add(p);
      		}
      	}
          return beklædninger;
      }
    
      
    
    //-------Anlæg---------------------------------------------------
      
      
  	//create
  	public static Produkt createAnlæg(String kategori, String produktNavn, boolean afleveret, double brugtFustagemængde,
			double brugtKulsyremængde, double anlægsPris) {
  		if(Salgssituation.isFredagsbarMode()) {
  			return null;
  		}
  		Produkt anlæg = new Anlæg(kategori,produktNavn,afleveret,brugtFustagemængde,brugtKulsyremængde,anlægsPris);
  		Storage.addProdukt(anlæg);
  		//TODO Hvordan skal der tilføjes Kulsyre og Fustager til Anlæg
  		return anlæg;
  	}
  	
  	//update
      public static void updateAnlæg(Anlæg anlæg, String kategori, String produktNavn, boolean afleveret, double brugtFustagemængde,
  			double brugtKulsyremængde, double anlægsPris) {
    	  anlæg.setKategori(kategori);
    	  anlæg.setProduktNavn(produktNavn);
    	  anlæg.setAfleveret(afleveret);
    	  anlæg.setBrugtFustagemængde(brugtFustagemængde);
    	  anlæg.setBrugtKulsyremængde(brugtKulsyremængde);
    	  anlæg.setPris(anlægsPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getAnlægsEnheder() {
      	ArrayList<Produkt> anlægsEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("anlæg")) {
      			anlægsEnheder.add(p);
      		}
      	}
          return anlægsEnheder;
      } 

      
    
    //-------Glas---------------------------------------------------
      
      
  	//create
  	public static Produkt createGlas(String kategori, String produktNavn, double butiksPris) {
  		if(Salgssituation.isFredagsbarMode()) {
  			return null;
  		}else {
  	  		Produkt glas = new Glas(kategori, produktNavn, butiksPris);
  	  		Storage.addProdukt(glas);
  	  		return glas;
  		}
  	}
  	
  	//update
      public static void updateGlas(Glas glas, String kategori, String produktNavn, double butiksPris) {
    	  glas.setKategori(kategori);
    	  glas.setProduktNavn(produktNavn);
    	  glas.setButiksPris(butiksPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getGlasEnheder() {
      	ArrayList<Produkt> glasEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("glas")) {
      			glasEnheder.add(p);
      		}
      	}
          return glasEnheder;
      }

      
    
    //-------Sampakninger---------------------------------------------------
      
      
  	//create
  	public static Produkt createSampakning(String kategori, String produktNavn, int antalØl, int antalGlas, double fredagsbarPris,
			double butiksPris) {
  		Produkt sampakning = new Sampakninger(kategori,produktNavn,antalØl,antalGlas,fredagsbarPris,butiksPris);
  		Storage.addProdukt(sampakning);
  		return sampakning;
  	}
  	
  	//update
      public static void updateSampakning(Sampakninger sampakning, String kategori, String produktNavn, int antalØl, int antalGlas, double fredagsbarPris,
  			double butiksPris) {
    	  sampakning.setKategori(kategori);
    	  sampakning.setProduktNavn(produktNavn);
    	  sampakning.setAntalØl(antalØl);
    	  sampakning.setAntalGlas(antalGlas);
    	  sampakning.setFredagsbarPris(fredagsbarPris);
    	  sampakning.setButiksPris(butiksPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getSampakninger() {
      	ArrayList<Produkt> sampakninger = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("sampakninger")) {
      			sampakninger.add(p);
      		}
      	}
          return sampakninger;
      }

    
      
    //-------Rundvisning---------------------------------------------------
      
      
  	//create
  	public static Produkt createRundvisning(String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt, double aftenPris,
			double dagsPris, double studierabat) {
  		if(Salgssituation.isFredagsbarMode()) {
  			return null;
  		}else {
  	  		Produkt rundvisning = new Rundvisning(kategori,produktNavn,dato,tidspunkt,aftenPris,dagsPris,studierabat);
  	  		Storage.addProdukt(rundvisning);
  	  		return rundvisning;
  		}
  	}
  	
  	//update
      public static void updateRundvisning(Rundvisning rundvisning, String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt, double aftenPris,
  			double dagsPris, double studierabat) {
    	  rundvisning.setKategori(kategori);
    	  rundvisning.setProduktNavn(produktNavn);
    	  rundvisning.setDato(dato);
    	  rundvisning.setTidspunkt(tidspunkt);
    	  rundvisning.setAftenPris(aftenPris);
    	  rundvisning.setDagsPris(dagsPris);
    	  rundvisning.setStudierabat(studierabat);
      }
  	
  	//get
      public static ArrayList<Produkt> getRundvisninger() {
      	ArrayList<Produkt> rundvisninger = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("rundvisning")) {
      			rundvisninger.add(p);
      		}
      	}
          return rundvisninger;
      }

      
      
    //-------Klippekort---------------------------------------------------
      
      
  	//create
  	public static Produkt createKlippekort(String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
  		if(Salgssituation.isFredagsbarMode()) {
  			return null;
  		}else {
  	  		Produkt klippekort = new Klippekort(kategori, produktNavn, fredagsbarPris, butiksPris);
  	  		Storage.addProdukt(klippekort);
  	  		return klippekort;
  		}
  	}
  	
  	//update
      public static void updateKlippekort(Klippekort klippekort, String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
    	  klippekort.setKategori(kategori);
    	  klippekort.setProduktNavn(produktNavn);
    	  klippekort.setFredagsbarPris(fredagsbarPris);
    	  klippekort.setButiksPris(butiksPris);
      }
  	
  	//get
      public static ArrayList<Produkt> getKlippekortEnheder() {
      	ArrayList<Produkt> klippekortEnheder = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("klippekort")) {
      			klippekortEnheder.add(p);
      		}
      	}
          return klippekortEnheder;
      }


      
      
      
      /**
       * Registrer og hent alle salgsenheder
       */
      
      //create
      public static Salg createSalg(Salgssituation salgssituation, Betalingsform betalingsform) {
    	Salg salg = new Salg(salgssituation, betalingsform);
    	Storage.addSalg(salg);
    	return salg;
      }
          	
    	//update
      public static void updateSalg(Salg salg, Salgssituation salgssituation, Betalingsform betalingsform) {
    	  salg.setSalgssituation(salgssituation);
    	  salg.setBetalingsform(betalingsform);
      }
    	
      //get
      public static ArrayList<Salg> getSalgsEnheder() {
          return Storage.getSalgsenheder();
      }
      
      

      /**
       * set og hent salgssituation
       */
//      public static Salgssituation getSalgssituation() {
//    	  return salgssituaion;
//      }
//
//      public static void setSalgssituation(Salgssituation situation) {
//    	  salgssituaion = situation;
//      }
	
	
	//Init storage

      
      
      
}

package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.*;
import model.betalingsform.*;
import model.rabat.*;
import storage.Storage;
import model.produkter.*;

public class Controller {


	//-------Produkter---------------------------------------------------
    
	
	//create
  	public static Beklædning createBeklædning(String kategori, String produktNavn) {
  		Beklædning beklædning = new Beklædning(kategori, produktNavn);
  		Storage.addProdukt(beklædning);
  		return beklædning;
  	}
  	
  	public static Fadøl createFadøl(String kategori, String produktNavn) {
  		Fadøl fadøl = new Fadøl(kategori, produktNavn);
  		Storage.addProdukt(fadøl);
  		return fadøl;
  	}
  		
  	public static Flaske createFlaske(String kategori, String produktNavn) {
  		Flaske flaske = new Flaske(kategori, produktNavn);
  		Storage.addProdukt(flaske);
  		return flaske;
  	}
	
  	public static Fustage createFustage(String kategori, String produktNavn, double mængde, double pant) {
  		//TODO Fejlhåndtering
  		Fustage fustage = new Fustage(kategori, produktNavn, mængde, pant);
  		Storage.addProdukt(fustage);
  		return fustage;
  	}

  	public static Kulsyre createKulsyre(String kategori, String produktNavn, double mængde, double pant) {
  		Kulsyre kulsyre = new Kulsyre(kategori, produktNavn, mængde, pant);
  		Storage.addProdukt(kulsyre);
  		return kulsyre;
  	}

	public static Malt createMalt(String kategori, String produktNavn) {
		Malt malt = new Malt(kategori, produktNavn);
		Storage.addProdukt(malt);
		return malt;
	}
	
	public static Sampakninger createSampaktninger(String kategori, String produktNavn) {
		Sampakninger sampakning = new Sampakninger(kategori, produktNavn);
		Storage.addProdukt(sampakning);
		return sampakning;
	}
	
	public static Spiritus createSpiritus(String kategori, String produktNavn) {
		Spiritus spiritus = new Spiritus(kategori, produktNavn);
		Storage.addProdukt(spiritus);
		return spiritus;
	}
		
    
    
    //-------Anlæg---------------------------------------------------
      
      
  	//create
  	public static Anlæg createAnlæg(String kategori, String produktNavn) {
  		Anlæg anlæg = new Anlæg(kategori,produktNavn);
  		Storage.addProdukt(anlæg);
  		return anlæg;
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
      
    
      
    //-------Rundvisning---------------------------------------------------
      
      
  	//create
  	public static Rundvisning createRundvisning(String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt) {
  		Rundvisning rundvisning = new Rundvisning(kategori,produktNavn,dato,tidspunkt);
  	  	Storage.addProdukt(rundvisning);
  	  	return rundvisning;
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
  	public static Klippekort createKlippekort(String kategori, String produktNavn) {
  	  	Klippekort klippekort = new Klippekort(kategori, produktNavn);
  	  	Storage.addProdukt(klippekort);
  	  	Storage.addBetalingsform((IBetalingsform)klippekort);	//TODO Overvej om klippekort skal tilføjes til begge lister
  	  	return klippekort;
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

    
    
  //-------Prisliste---------------------------------------------------
    
    
	//create
	public static PrisListe createPrisliste(String arrangement) {
		PrisListe prisliste = new PrisListe(arrangement);
	  	Storage.addPrisliste(prisliste);
	  	return prisliste;
	}
	
	//get
    public static ArrayList<PrisListe> getPrislister() {
    	return Storage.getPrislister();
    }

    
    //-------ProcentvisRabat---------------------------------------------------
    
    
  	//create
  	public static ProcentvisRabat createProcentvisRabat(double procent) {
  		ProcentvisRabat procentvisRabat = new ProcentvisRabat(procent);
  	  	Storage.addRabat(procentvisRabat);
  	  	return procentvisRabat;
  	}
  	
  	//get
    public static ArrayList<Rabat> getRabatter() {
      	return Storage.getRabatter();
    }

    
    
    //-------StudieRabat---------------------------------------------------
    
    
  	//create
  	public static StudieRabat createStudieRabat(ProduktLinje produktlinje, int antalStuderende, double rabatProcent) {
  		StudieRabat studieRabat = new StudieRabat(produktlinje, antalStuderende, rabatProcent);
  	  	Storage.addRabat(studieRabat);
  	  	return studieRabat;
  	}
  	
  	
  	//get TODO Er det nødvendigt at lave en get-metode for alle rabatter eller er det nok med én
    
    
    //-------Betalingsform---------------------------------------------------
    
    
    //TODO Hav styr på hvornår der skal bruges Betalingsform og IBetalingsform
    
  	//create
  	public static Betalingsform createBetalingsform() {
  		Betalingsform betalingsform = new Betalingsform();
  	  	Storage.addBetalingsform(betalingsform);
  	  	return betalingsform;
  	}
  	
  	//update TODO ingen attributter i contructoren for Betalingsform
  	
  	
  	//get
    public static ArrayList<IBetalingsform> getBetalingsformer() {
      	return Storage.getBetalingsformer();
    }

      
      
      
    /**
     * Registrer og hent alle salgsenheder
     */
      
    //create
    public static Salg createSalg() {
    	Salg salg = new Salg();
    	Storage.addSalg(salg);
    	return salg;
    }
          	
    //update - unødvendig, der er ingen parametre i constructoren
    	

    //get
    public static ArrayList<Salg> getSalgsEnheder() {
    	return Storage.getSalgsenheder();
    }
      
	
	
	//Init storage
    public static void initStorage() {
    	
    	Flaske f1 = Controller.createFlaske("flaske", "Klosterbryg");
    	Flaske f2 = Controller.createFlaske("flaske", "sweet georgia brown");
    	Flaske f3 = Controller.createFlaske("flaske", "ekstra pilsner");
    	
    	
    	PrisListe fredagsbar = Controller.createPrisliste("fredagsbar");
    	Pris p1 = fredagsbar.createPris(f1, 50);
    	Pris p2 = fredagsbar.createPris(f2, 50);
    	Pris p3 = fredagsbar.createPris(f3, 50);
    	
    	
    	PrisListe butikspris = Controller.createPrisliste("butik");
    	Pris p4 = butikspris.createPris(f1, 36);
    	Pris p5 = butikspris.createPris(f2, 36);
    	Pris p6 = butikspris.createPris(f3, 36);
    	
    }
      
      
      
}

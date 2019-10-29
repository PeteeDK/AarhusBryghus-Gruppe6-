package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.*;
import model.betalingsform.*;
import model.rabat.*;
import storage.Storage;

public class Controller {

	
	
    //-------Tilbehør---------------------------------------------------

	//create
  	public static Produkt createTilbehør(String kategori, String produktNavn, double mængde, double pant) {
  		//TODO Fejlhåndtering
  		Produkt tilbehør = new Tilbehør(kategori, produktNavn, mængde, pant);
  		Storage.addProdukt(tilbehør);
  		return tilbehør;
  	}
  	
  	//update
  	public static void updateTilbehør(Tilbehør tilbehør, String kategori, String produktNavn, double mængde, double pant) {
  		tilbehør.setKategori(kategori);
    	tilbehør.setProduktNavn(produktNavn);
    	tilbehør.setMængde(mængde);
    	tilbehør.setPant(pant);
      }
  	
  	//get	TODO Skal tilbehør gemmes i sin egen ArrayList i storage
    public static ArrayList<Produkt> getTilbehør() {
    	ArrayList<Produkt> tilbehør = new ArrayList<>();
      	for(Produkt p : Storage.getProdukter()) {
      		if(p.getKategori().equals("fustage") || p.getKategori().equals("kulsyre")) {
      			tilbehør.add(p);
      		}
      	}
          return tilbehør;
      } 

    
	
	
    //-------Produkt---------------------------------------------------

	//create
  	public static Produkt createProdukt(String kategori, String produktNavn) {
  		//TODO Fejlhåndtering
  		Produkt produkt = new Produkt(kategori, produktNavn);
  		Storage.addProdukt(produkt);
  		return produkt;
  	}
  	
  	//update
  	public static void updateProdukt(Produkt produkt, String kategori, String produktNavn) {
  		produkt.setKategori(kategori);
  		produkt.setProduktNavn(produktNavn);
  	}
  	
  	//get	TODO Skal tilbehør gemmes i sin egen ArrayList i storage
    public static ArrayList<Produkt> getProdukter() {
    	return Storage.getProdukter();
    } 
	
    
    
    //-------Anlæg---------------------------------------------------
      
      
  	//create
  	public static Anlæg createAnlæg(String kategori, String produktNavn) {
  		Anlæg anlæg = new Anlæg(kategori,produktNavn);
  		Storage.addProdukt(anlæg);
  		return anlæg;
  	}
  	
  	//update	TODO Overvej om der skal flere enheder på i contructoren. umiddelbart er det fint
    public static void updateAnlæg(Anlæg anlæg, String kategori, String produktNavn) {
  	    anlæg.setKategori(kategori);
  	    anlæg.setProduktNavn(produktNavn);
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
      
    
    //-------Sampakninger---------------------------------------------------
      
      
  	//create	TODO Overvej helt at fjerne den, da den kan blive oprette under Produkt og antalØl og antalGlas gør ikke godt for noget 
  	public static Produkt createSampakning(String kategori, String produktNavn, int antalØl, int antalGlas) {
  		Produkt sampakning = new Sampakninger(kategori,produktNavn,antalØl,antalGlas);
  		Storage.addProdukt(sampakning);
  		return sampakning;
  	}
  	
  	//update
    public static void updateSampakning(Sampakninger sampakning, String kategori, String produktNavn, int antalØl, int antalGlas) {
    	sampakning.setKategori(kategori);
    	sampakning.setProduktNavn(produktNavn);
    	sampakning.setAntalØl(antalØl);
    	sampakning.setAntalGlas(antalGlas);
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
  	public static Rundvisning createRundvisning(String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt) {
  		Rundvisning rundvisning = new Rundvisning(kategori,produktNavn,dato,tidspunkt);
  	  	Storage.addProdukt(rundvisning);
  	  	return rundvisning;
  	}
  	
  	//update
    public static void updateRundvisning(Rundvisning rundvisning, String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt) {
    	rundvisning.setKategori(kategori);
    	rundvisning.setProduktNavn(produktNavn);
    	rundvisning.setDato(dato);
    	rundvisning.setTidspunkt(tidspunkt);
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
  	public static Produkt createKlippekort(String kategori, String produktNavn) {
  	  	Produkt klippekort = new Klippekort(kategori, produktNavn);
  	  	Storage.addProdukt(klippekort);
  	  	return klippekort;
  	}
  	
  	//update
    public static void updateKlippekort(Klippekort klippekort, String kategori, String produktNavn) {
    	klippekort.setKategori(kategori);
    	klippekort.setProduktNavn(produktNavn);
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
	
	//update
    public static void updatePrisliste(PrisListe prisliste, String arrangement) {
  	    prisliste.setArrangement(arrangement);
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
  	
  	//update
    public static void updateProcentvisRabat(ProcentvisRabat procentvisRabat, double procent) {
        procentvisRabat.setProcent(procent);;
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
  	
  	//update
    public static void updateStudieRabat(StudieRabat studierabat, ProduktLinje produktlinje, int antalStuderende, double rabatProcent) {
    	studierabat.setProduktlinje(produktlinje);
    	studierabat.setAntalStuderende(antalStuderende);
    	studierabat.setRabatProcent(rabatProcent);
    }
  	
  	//get TODO Er det nødvendigt at lave en get-metode for alle rabatter eller er det nok med én
    
      
      
      
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
   
    public static ArrayList<Pris> getPriser(){
    	ArrayList<Pris> priser = new ArrayList<>();
    	for(PrisListe pl : Controller.getPrislister()) {
    		for(Pris p : pl.getPriser()) {
    			priser.add(p);
    		}
    	}
    	return priser;
    }
    
    public static void initStorage() {
    	
    	Produkt f1 = Controller.createProdukt("Flaske", "Klosterbryg");
    	Produkt f2 = Controller.createProdukt("Flaske", "Sweet Georgia Brown");
    	Produkt f3 = Controller.createProdukt("Flaske", "Celebration");
    	Produkt f4 = Controller.createProdukt("Flaske", "Blondie");
    	Produkt f5 = Controller.createProdukt("Flaske", "Forårsbryg");
    	Produkt f6 = Controller.createProdukt("Flaske", "Ekstra Pilsner");
    	Produkt f7 = Controller.createProdukt("Flaske", "India Pale Ale");
    	Produkt f8 = Controller.createProdukt("Flaske", "Julebryg");
    	Produkt f9 = Controller.createProdukt("Flaske", "Juletønden");
    	Produkt f10 = Controller.createProdukt("Flaske", "Old Strong Ale");
    	Produkt f11 = Controller.createProdukt("Flaske", "Fregatten Jylland");
    	Produkt f12 = Controller.createProdukt("Flaske", "Imperial Stout");
    	Produkt f13 = Controller.createProdukt("Flaske", "Tribute");
    	Produkt f14 = Controller.createProdukt("Flaske", "Black Monster");
    	
    	
    	PrisListe fredagsbar = Controller.createPrisliste("Fredagsbar");
    	Pris fp1 = fredagsbar.createPris(f1, 50);
    	Pris fp2 = fredagsbar.createPris(f2, 50);
    	Pris fp3 = fredagsbar.createPris(f3, 50);
    	Pris fp4 = fredagsbar.createPris(f4, 50);
    	Pris fp5 = fredagsbar.createPris(f5, 50);
    	Pris fp6 = fredagsbar.createPris(f6, 50);
    	Pris fp7 = fredagsbar.createPris(f7, 50);
    	Pris fp8 = fredagsbar.createPris(f8, 50);
    	Pris fp9 = fredagsbar.createPris(f9, 50);
    	Pris fp10 = fredagsbar.createPris(f10, 50);
    	Pris fp11 = fredagsbar.createPris(f11, 50);
    	Pris fp12 = fredagsbar.createPris(f12, 50);
    	Pris fp13 = fredagsbar.createPris(f13, 50);
    	Pris fp14 = fredagsbar.createPris(f14, 50);
    	
    	
    	
    	PrisListe butiksPris = Controller.createPrisliste("Butikspris");
    	Pris bp1 = butiksPris.createPris(f1, 36);
    	Pris bp2 = butiksPris.createPris(f2, 36);
    	Pris bp3 = butiksPris.createPris(f3, 36);
    	Pris bp4 = butiksPris.createPris(f4, 36);
    	Pris bp5 = butiksPris.createPris(f5, 36);
    	Pris bp6 = butiksPris.createPris(f6, 36);
    	Pris bp7 = butiksPris.createPris(f7, 36);
    	Pris bp8 = butiksPris.createPris(f8, 36);
    	Pris bp9 = butiksPris.createPris(f9, 36);
    	Pris bp10 = butiksPris.createPris(f10, 36);
    	Pris bp11 = butiksPris.createPris(f11, 36);
    	Pris bp12 = butiksPris.createPris(f12, 36);
    	Pris bp13 = butiksPris.createPris(f13, 36);
    	Pris bp14 = butiksPris.createPris(f14, 50);
    	
    }

      
      
      
}

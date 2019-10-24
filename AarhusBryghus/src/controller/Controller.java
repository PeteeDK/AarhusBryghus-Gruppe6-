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
      
	
	
	//Init storage

      
      
      
}

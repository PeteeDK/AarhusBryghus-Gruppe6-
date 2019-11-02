package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	
  	public static Fustage createFustage(String kategori, String produktNavn, double mængde) {
  		//TODO Fejlhåndtering
  		Fustage fustage = new Fustage(kategori, produktNavn, mængde);
  		Storage.addProdukt(fustage);
  		return fustage;
  	}

  	public static Kulsyre createKulsyre(String kategori, String produktNavn, double mængde) {
  		Kulsyre kulsyre = new Kulsyre(kategori, produktNavn, mængde);
  		Storage.addProdukt(kulsyre);
  		return kulsyre;
  	}

	public static Malt createMalt(String kategori, String produktNavn) {
		Malt malt = new Malt(kategori, produktNavn);
		Storage.addProdukt(malt);
		return malt;
	}
	
	public static Sampakninger createSampakninger(String kategori, String produktNavn, int antalØl, int antalGlas) {
		Sampakninger sampakning = new Sampakninger(kategori, produktNavn,antalØl,antalGlas);
		Storage.addProdukt(sampakning);
		return sampakning;
	}
	
	public static Spiritus createSpiritus(String kategori, String produktNavn) {
		Spiritus spiritus = new Spiritus(kategori, produktNavn);
		Storage.addProdukt(spiritus);
		return spiritus;
	}
		
	public static Glas createGlas(String kategori, String produktNavn) {
		Glas glas = new Glas(kategori, produktNavn);
		Storage.addProdukt(glas);
		return glas;
	}


	//----get------------------------------------------------------------------
	
    public static ArrayList<Produkt> getBeklædninger() {
        ArrayList<Produkt> beklædninger = new ArrayList<>();
        for(Produkt p : Storage.getProdukter()) {
      	  if(p.getKategori().equals("beklædning")) {
      		  beklædninger.add(p);
        	  }
        }
        return beklædninger;
    }

    public static ArrayList<Produkt> getFadølsenheder() {
        ArrayList<Produkt> beklædninger = new ArrayList<>();
        for(Produkt p : Storage.getProdukter()) {
      	  if(p.getKategori().equals("beklædning")) {
      		  beklædninger.add(p);
        	  }
        }
        return beklædninger;
    }

    
    public static Produkt getGlas() {
        Produkt glas = null;
        for(Produkt p : Storage.getProdukter()) {
      	  if(p.getKategori().equals("glas")) {
      		  glas = p;
      	  }
        }
        return glas;
    }
    
    
    
    public static ArrayList<Produkt> getProdukter(){
    	return Storage.getProdukter();
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
  	public static Rundvisning createRundvisning(String kategori, String produktNavn) {
  		Rundvisning rundvisning = new Rundvisning(kategori,produktNavn);
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
    
    
    public static ArrayList<Pris> getPriser(String arg){
    	ArrayList<Pris> priser = new ArrayList<>();
    	for(PrisListe pl : Controller.getPrislister()) {
    		if(pl.getArrangement().equals(arg)) {
        		for(Pris p : pl.getPriser()) {
        			priser.add(p);
        		}
    		}
    	}
    	return priser;
    }
    
    
    public static ArrayList<Pris> getPriserEfterArrangementOgKategori(String arrangement, String kategori){
    	ArrayList<Pris> priser = new ArrayList<>();
    	for(PrisListe pl : Controller.getPrislister()) {
    		if(pl.getArrangement().equals(arrangement)) {
    			for(Pris p : pl.getPriser()) {
    				if(p.getProdukt().getKategori().equals(kategori)) {
        				priser.add(p);
    				}
    			}
    		}
    	}
    	return priser;
    }
    
    
    public static ArrayList<Pris> getPriserEfterKategori(String kategori){
    	ArrayList<Pris> priser = new ArrayList<>();
    	for(PrisListe pl : Controller.getPrislister()) {
   			for(Pris p : pl.getPriser()) {
   				if(p.getProdukt().getKategori().equals(kategori)) {
       				priser.add(p);
   				}
   			}
    	}
    	return priser;
    }


    public static ArrayList<Produkt> getProdukterEfterKategori(String kategori){
    	ArrayList<Produkt> produkter = new ArrayList<>();
    	for(Produkt p : Storage.getProdukter()) {
    		if(p.getKategori().equals(kategori)) {
    			produkter.add(p);
    		}
    	}
    	return produkter;
    }
    
    
    
    public static String[] getKategorier(){
    	Set<String> kategorierSet = new HashSet<String>();
    	for(Produkt p : Storage.getProdukter()) {
    		kategorierSet.add(p.getKategori());
    	}
    	String[] kategorier = new String[kategorierSet.size()];
    	int i = 0;
    	for(String k : kategorierSet) {
    		kategorier[i] = k;
    		i++;
    	}
     	return kategorier;
    }
    
    
    //create produktlinje
    
    public static ProduktLinje createProduktLinje(Pris pris, int antal) {
    	ProduktLinje produktLinje = new ProduktLinje(pris, antal);
    	Storage.addProduktLinje(produktLinje);
    	return produktLinje;
    }
    
    public static void updateProduktLinje(ProduktLinje produktlinje, Pris pris, int antal) {
    	produktlinje.setPris(pris);
    	produktlinje.setAntal(antal);
    }

	public static void removeProduktLinje(ProduktLinje produktlinje) {
		Storage.removeProduktLinje(produktlinje);
	}

	public static ArrayList<ProduktLinje> getProduktlinjer(){
		return Storage.getProduktLinjer();
	}
	
    
    
    //get prisliste-arrangement - bruges i [Bestilling -> "comboBox"]
    public static String[] getArrangementer(){
    	String[] arrangementer = new String[Controller.getPrislister().size()];
    	int i = 0;
    	for(PrisListe pl : Controller.getPrislister()) {
    		arrangementer[i] = pl.getArrangement();
    		i++;
    	}
    	return arrangementer;
    }
    
	public static ArrayList<Produkt> getSolgteKlippekort() {
		ArrayList<Produkt> solgteKlippekort = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("klippekort")) {
					int i = 0;
					while(i < pl.getAntal()) {
						solgteKlippekort.add(pl.getPrisObj().getProdukt());
						i++;
					}
				}else {
					solgteKlippekort.add(pl.getPrisObj().getProdukt());
				}
			}
		}
		return solgteKlippekort;
	} 

	
	public static ArrayList<Produkt> getSolgteAnlæg() {
		ArrayList<Produkt> solgteAnlæg = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("anlæg") && (pl.getPrisObj().getProdukt().getProduktNavn().equals("1-hane") || pl.getPrisObj().getProdukt().getProduktNavn().equals("2-haner") || pl.getPrisObj().getProdukt().getProduktNavn().equals("bar med flere haner"))) {
					int i = 0;
					while(i < pl.getAntal()) {
						solgteAnlæg.add(pl.getPrisObj().getProdukt());
						i++;
					}
				}
			}
		}
		return solgteAnlæg;
	}



	public static ArrayList<Produkt> getSolgteKlippekortMellemStartOgSlut(LocalDate startdato, LocalDate slutdato) {
		ArrayList<Produkt> solgteKlippekort = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("klippekort")) {
					Klippekort p = (Klippekort) pl.getPrisObj().getProdukt();
					if(p.getKøbsdato().isAfter(startdato) && p.getKøbsdato().isBefore(slutdato)) {
						int i = 0;
						while(i < pl.getAntal()) {
							solgteKlippekort.add(pl.getPrisObj().getProdukt());
							i++;
						}
					}
				}
			}
		}
		return solgteKlippekort;
	}

    
	public static ArrayList<String> getBrugteKlipMellemStartOgSlut(LocalDate startDato, LocalDate slutDato, boolean brugt) {
		//arrayList Klip
		ArrayList<String> brugteKlip = new ArrayList<>();
		
		//tag solgte klippekort i periode
		for(Produkt kk : getSolgteKlippekortMellemStartOgSlut(startDato, slutDato)) {
			
			//udtræk klip fra Klippekort klip-liste
			for(Klip k : ((Klippekort) kk).getKlipEnheder()) {
			
				//hvis brugt = "true" tilføj de klip,  hvor [klip->brugt() = true] 
				if(brugt == true) {
					if(k.isBrugt()) {
						String message = "KlippekortID: " + ((Klippekort) kk).getId() + " " + k.toString(); 
						brugteKlip.add(message);
					}
				}else {
					if(!k.isBrugt()) {
						String message = "KlippekortID: " + ((Klippekort) kk).getId() + " " + k.toString(); 
						brugteKlip.add(message);
					}
				}
			}
		}
		return brugteKlip;
	}


	public static ArrayList<Produkt> getIkkeAfleveredeAnlægMellemStartOgSlut(LocalDate startdato, LocalDate slutdato) {
		//arrayList Klip
		ArrayList<Produkt> ikkeAfleveredeAnlæg = new ArrayList<>();
		
		//tag solgte klippekort i periode
		for(Produkt p : getSolgteAnlæg()) {
			
			if(!((Anlæg) p).isAfleveret() && ((Anlæg) p).getKøbsdato().isAfter(startdato) && ((Anlæg) p).getKøbsdato().isBefore(slutdato)) {
				ikkeAfleveredeAnlæg.add(p);
			}
			System.out.println("[Controller -> getIkkeAfleveredeAnlægMellemStartOgSlut] " + ikkeAfleveredeAnlæg);
		}
		return ikkeAfleveredeAnlæg;
	
	}

	
	public static ArrayList<Salg> getDagensSalgMellemStartOgSlut(LocalDate startdato, LocalDate slutdato){
		ArrayList<Salg> dagensSalg = new ArrayList<>();
		for(Salg s : Controller.getSalgsEnheder()) {
			if(s.getSalgsdato().isAfter(startdato) && s.getSalgsdato().isBefore(slutdato)) {
				dagensSalg.add(s);
			}
		}
		return dagensSalg;
	}
	
	
	
	
	
	

	

	
	
	//Init storage
    public static void initStorage() {
    	
    	//----Produkter--------------------------------------------------------------------
    	
    	//TODO Unødvendigt at bruge Controller...
    	
    	Flaske flaske1 = Controller.createFlaske("flaske", "klosterbryg");
    	Flaske flaske2 = Controller.createFlaske("flaske", "sweet georgia brown");
    	Flaske flaske3 = Controller.createFlaske("flaske", "ekstra pilsner");
    	Flaske flaske4 = Controller.createFlaske("flaske", "celebration");
    	Flaske flaske5 = Controller.createFlaske("flaske", "blondie");
    	Flaske flaske6 = Controller.createFlaske("flaske", "forårsbryg");
    	Flaske flaske7 = Controller.createFlaske("flaske", "india pale ale");
    	Flaske flaske8 = Controller.createFlaske("flaske", "julebryg");
    	Flaske flaske9 = Controller.createFlaske("flaske", "juletønden");
    	Flaske flaske10 = Controller.createFlaske("flaske", "old strong ale");
    	Flaske flaske11 = Controller.createFlaske("flaske", "fregatten jylland");
    	Flaske flaske12 = Controller.createFlaske("flaske", "imperial stout");
    	Flaske flaske13 = Controller.createFlaske("flaske", "tribute");
    	Flaske flaske14 = Controller.createFlaske("flaske", "black monster");

    	Fadøl fadøl1 = Controller.createFadøl("fadøl", "klosterbryg");
    	Fadøl fadøl2 = Controller.createFadøl("fadøl", "jazz classic");
    	Fadøl fadøl3 = Controller.createFadøl("fadøl", "ekstra pilsner");
    	Fadøl fadøl4 = Controller.createFadøl("fadøl", "celebration");
    	Fadøl fadøl5 = Controller.createFadøl("fadøl", "blondie");
    	Fadøl fadøl6 = Controller.createFadøl("fadøl", "forårsbryg");
    	Fadøl fadøl7 = Controller.createFadøl("fadøl", "india pale ale");
    	Fadøl fadøl8 = Controller.createFadøl("fadøl", "julebryg");
    	Fadøl fadøl9 = Controller.createFadøl("fadøl", "imperial stout");
    	Fadøl fadøl10 = Controller.createFadøl("fadøl", "special");
    	Fadøl fadøl11 = Controller.createFadøl("fadøl", "æblebrus");
    	Fadøl fadøl12 = Controller.createFadøl("fadøl", "chips");
    	Fadøl fadøl13 = Controller.createFadøl("fadøl", "peanuts");
    	Fadøl fadøl14 = Controller.createFadøl("fadøl", "cola");
    	Fadøl fadøl15 = Controller.createFadøl("fadøl", "nikoline");
    	Fadøl fadøl16 = Controller.createFadøl("fadøl", "7-up");
    	Fadøl fadøl17 = Controller.createFadøl("fadøl", "vand");

    	Spiritus spiritus1 = Controller.createSpiritus("spiritus", "spirit of aarhus");
    	Spiritus spiritus2 = Controller.createSpiritus("spiritus", "soa med pind");
    	Spiritus spiritus3 = Controller.createSpiritus("spiritus", "whiskey");
    	Spiritus spiritus4 = Controller.createSpiritus("spiritus", "liquor of aarhus");
    	
    	Fustage fustage1 = Controller.createFustage("fustage", "klosterbryg", 20);
    	Fustage fustage2 = Controller.createFustage("fustage", "jazz classic", 25);
    	Fustage fustage3 = Controller.createFustage("fustage", "ekstra pilsner", 25);
    	Fustage fustage4 = Controller.createFustage("fustage", "celebration", 20);
    	Fustage fustage5 = Controller.createFustage("fustage", "blondie", 25);
    	Fustage fustage6 = Controller.createFustage("fustage", "forårsbryg", 20);
    	Fustage fustage7 = Controller.createFustage("fustage", "india pale", 20);
    	Fustage fustage8 = Controller.createFustage("fustage", "julebryg", 20);
    	Fustage fustage9 = Controller.createFustage("fustage", "imperial stout", 20);

    	Kulsyre kulsyre1 = Controller.createKulsyre("kulsyre", "", 6);
    	Kulsyre kulsyre2 = Controller.createKulsyre("kulsyre", "", 4);
    	Kulsyre kulsyre3 = Controller.createKulsyre("kulsyre", "", 10);
    	
    	Malt malt1 = Controller.createMalt("malt", "25 kg sæk");
    	
    	Beklædning beklædning1 = Controller.createBeklædning("beklædning", "t-shirt");
    	Beklædning beklædning2 = Controller.createBeklædning("beklædning", "polo");
    	Beklædning beklædning3 = Controller.createBeklædning("beklædning", "cap");
    	
    	Anlæg anlæg1 = Controller.createAnlæg("anlæg", "1-hane");
    	Anlæg anlæg2 = Controller.createAnlæg("anlæg", "2-haner");
    	Anlæg anlæg3 = Controller.createAnlæg("anlæg", "bar med flere haner");
    	Anlæg anlæg4 = Controller.createAnlæg("anlæg", "levering");
    	Anlæg anlæg5 = Controller.createAnlæg("anlæg", "krus");
    	
    	Glas glas1 = Controller.createGlas("glas", "");
    	
    	Sampakninger sampakninger1 = Controller.createSampakninger("sampakninger", "gaveæske 2 øl, 2 glas",2,2);
    	Sampakninger sampakninger2 = Controller.createSampakninger("sampakninger", "gaveæske 4 øl",4,0);
    	Sampakninger sampakninger3 = Controller.createSampakninger("sampakninger", "trækasse 4 øl",6,0);
    	Sampakninger sampakninger4 = Controller.createSampakninger("sampakninger", "gaveæske 6 øl, 2 glas",6,2);
    	Sampakninger sampakninger5 = Controller.createSampakninger("sampakninger", "gaveæske 6 øl, 6 glas",6,6);
    	Sampakninger sampakninger6 = Controller.createSampakninger("sampakninger", "trækasse 12 øl",12,0);
    	Sampakninger sampakninger7 = Controller.createSampakninger("sampakninger", "papkasse 12 øl",12,0);

    	Rundvisning rundvisning1 = Controller.createRundvisning("rundvisning", "");
    	
    	Klippekort klippekort1 = Controller.createKlippekort("klippekort", "klippekort, 4 klip");
    	Klippekort klippekort2 = Controller.createKlippekort("klippekort", "klippekort, 4 klip");

    	
    	//----PrisListe-fredagsbar-------------------------------------------------------------------
    	
    	//flasker
    	
    	PrisListe fredagsbar = Controller.createPrisliste("fredagsbar");
    	Pris fp1 = fredagsbar.createPris(flaske1, 50);
    	Pris fp2 = fredagsbar.createPris(flaske2, 50);
    	Pris fp3 = fredagsbar.createPris(flaske3, 50);
    	Pris fp4 = fredagsbar.createPris(flaske4, 50);
    	Pris fp5 = fredagsbar.createPris(flaske5, 50);
    	Pris fp6 = fredagsbar.createPris(flaske6, 50);
    	Pris fp7 = fredagsbar.createPris(flaske7, 50);
    	Pris fp8 = fredagsbar.createPris(flaske8, 50);
    	Pris fp9 = fredagsbar.createPris(flaske9, 50);
    	Pris fp10 = fredagsbar.createPris(flaske10, 50);
    	Pris fp11 = fredagsbar.createPris(flaske11, 50);
    	Pris fp12 = fredagsbar.createPris(flaske12, 50);
    	Pris fp13 = fredagsbar.createPris(flaske13, 50);
    	Pris fp14 = fredagsbar.createPris(flaske14, 50);

    	//fadøl
    	
    	Pris fp15 = fredagsbar.createPris(fadøl1, 30);
    	Pris fp16 = fredagsbar.createPris(fadøl2, 30);
    	Pris fp17 = fredagsbar.createPris(fadøl3, 30);
    	Pris fp18 = fredagsbar.createPris(fadøl4, 30);
    	Pris fp19 = fredagsbar.createPris(fadøl5, 30);
    	Pris fp20 = fredagsbar.createPris(fadøl6, 30);
    	Pris fp21 = fredagsbar.createPris(fadøl7, 30);
    	Pris fp22 = fredagsbar.createPris(fadøl8, 30);
    	Pris fp23 = fredagsbar.createPris(fadøl9, 30);
    	Pris fp24 = fredagsbar.createPris(fadøl10, 30);
    	Pris fp25 = fredagsbar.createPris(fadøl11, 15);
    	Pris fp26 = fredagsbar.createPris(fadøl12, 10);
    	Pris fp27 = fredagsbar.createPris(fadøl13, 10);
    	Pris fp28 = fredagsbar.createPris(fadøl14, 15);
    	Pris fp29 = fredagsbar.createPris(fadøl15, 15);
    	Pris fp30 = fredagsbar.createPris(fadøl16, 15);
    	Pris fp31 = fredagsbar.createPris(fadøl17, 10);

    	//spiritus
    	
    	Pris fp32 = fredagsbar.createPris(spiritus1, 300);
    	Pris fp33 = fredagsbar.createPris(spiritus2, 350);
    	Pris fp34 = fredagsbar.createPris(spiritus3, 500);
    	Pris fp35 = fredagsbar.createPris(spiritus4, 175);
    	
    	//kulsyre
    	
    	Pris fp36 = fredagsbar.createPris(kulsyre1, 400.0/6);
    	
    	//beklædning
    	
    	Pris fp37 = fredagsbar.createPris(beklædning1, 70);
    	Pris fp38 = fredagsbar.createPris(beklædning2, 100);
    	Pris fp39 = fredagsbar.createPris(beklædning3, 30);
    	
    	//sampakninger 
    	
    	Pris fp40 = fredagsbar.createPris(sampakninger1, 100);
    	Pris fp41 = fredagsbar.createPris(sampakninger2, 130);
    	Pris fp42 = fredagsbar.createPris(sampakninger3, 240);
    	Pris fp43 = fredagsbar.createPris(sampakninger4, 250);
    	Pris fp44 = fredagsbar.createPris(sampakninger5, 290);
    	Pris fp45 = fredagsbar.createPris(sampakninger6, 390);
    	Pris fp46 = fredagsbar.createPris(sampakninger7, 360);

    	//klippekort
    	
    	Pris fp47 = fredagsbar.createPris(klippekort1, 100);

    	
    	//----PrisListe-butik-------------------------------------------------------------------
    	
    	//flasker
    	
    	PrisListe butik = Controller.createPrisliste("butik");
    	Pris bp1 = butik.createPris(flaske1, 36);
    	Pris bp2 = butik.createPris(flaske2, 36);
    	Pris bp3 = butik.createPris(flaske3, 36);
    	Pris bp4 = butik.createPris(flaske4, 36);
    	Pris bp5 = butik.createPris(flaske5, 36);
    	Pris bp6 = butik.createPris(flaske6, 36);
    	Pris bp7 = butik.createPris(flaske7, 36);
    	Pris bp8 = butik.createPris(flaske8, 36);
    	Pris bp9 = butik.createPris(flaske9, 36);
    	Pris bp10 = butik.createPris(flaske10, 36);
    	Pris bp11 = butik.createPris(flaske11, 36);
    	Pris bp12 = butik.createPris(flaske12, 36);
    	Pris bp13 = butik.createPris(flaske13, 36);
    	Pris bp14 = butik.createPris(flaske14, 36);

    	//spiritus
    	
    	Pris bp15 = butik.createPris(spiritus1, 300);
    	Pris bp16 = butik.createPris(spiritus2, 350);
    	Pris bp17 = butik.createPris(spiritus3, 500);
    	Pris bp18 = butik.createPris(spiritus4, 175);
    	
    	//fustage
    	
    	Pris bp19 = butik.createPris(fustage1, 775.0/20);
    	Pris bp20 = butik.createPris(fustage2, 625.0/25);
    	Pris bp21 = butik.createPris(fustage3, 575.0/25);
    	Pris bp22 = butik.createPris(fustage4, 775.0/20);
    	Pris bp23 = butik.createPris(fustage5, 700.0/25);
    	Pris bp24 = butik.createPris(fustage6, 775.0/20);
    	Pris bp25 = butik.createPris(fustage7, 775.0/20);
    	Pris bp26 = butik.createPris(fustage8, 775.0/20);
    	Pris bp27 = butik.createPris(fustage9, 775.0/20);

    	//kulsyre
    	
    	Pris bp28 = butik.createPris(kulsyre1, 400.0/6);
    	
    	//malt
    	
    	Pris bp29 = butik.createPris(malt1, 300);
    	
    	//beklædning
    	
    	Pris bp30 = butik.createPris(beklædning1, 70);
    	Pris bp31 = butik.createPris(beklædning2, 100);
    	Pris bp32 = butik.createPris(beklædning3, 30);
    	
    	//anlæg
    	
    	Pris bp33 = butik.createPris(anlæg1, 250);
    	Pris bp34 = butik.createPris(anlæg2, 400);
    	Pris bp35 = butik.createPris(anlæg3, 500);
    	Pris bp36 = butik.createPris(anlæg4, 500);
    	Pris bp37 = butik.createPris(anlæg5, 60);

    	//glas
    	
    	Pris bp38 = butik.createPris(glas1, 15);

    	//sampakninger 
    	
    	Pris bp39 = butik.createPris(sampakninger1, 100);
    	Pris bp40 = butik.createPris(sampakninger2, 130);
    	Pris bp41 = butik.createPris(sampakninger3, 240);
    	Pris bp42 = butik.createPris(sampakninger4, 250);
    	Pris bp43 = butik.createPris(sampakninger5, 290);
    	Pris bp44 = butik.createPris(sampakninger6, 390);
    	Pris bp45 = butik.createPris(sampakninger7, 360);

    	//rundvisning

    	Pris bp46 = butik.createPris(rundvisning1, 100);
    	
    	//klippekort
    	
    	Pris bp47 = butik.createPris(klippekort1, 100);
    	Pris bp48 = butik.createPris(klippekort2, 100);
		//TODO Skal det samme klippekort kunne blive solgt igen, der skal evt. en sikkerhed attribut på Klippekort "erSolgt"

    	
    	// --------------------- Salg ---------------------------------------
    	
    	Salg salg1 = Controller.createSalg();
    	salg1.createProduktLinje(bp47, 2);
    	
       	Salg salg2 = Controller.createSalg();
    	salg1.createProduktLinje(bp48, 1);
    	
    	
    	
    	
    	
    	
    	// -------------------------------------------------------------------
    	 
    }


      
}

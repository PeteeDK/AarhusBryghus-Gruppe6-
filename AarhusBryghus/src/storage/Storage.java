package storage;

import java.util.ArrayList;

import model.*;
import model.betalingsform.*;
import model.rabat.*;

public class Storage { 

	//TODO Overvej andre collection-frameworks(datastrukturer)
	private static ArrayList<Produkt> produkter = new ArrayList<>();
	private static ArrayList<Salg> salgsEnheder = new ArrayList<>();
	private static ArrayList<PrisListe> prislister = new ArrayList<>();
	private static ArrayList<Rabat> rabatter = new ArrayList<>();
	private static ArrayList<IBetalingsform> betalingsformer = new ArrayList<>();
	private static ArrayList<ProduktLinje> produktlinjer = new ArrayList<>();


	// -------ProduktLinje---------------------------------------------

	public static ArrayList<ProduktLinje> getProduktLinjer() { 
		return new ArrayList<ProduktLinje>(produktlinjer);
	}

	public static void addProduktLinje(ProduktLinje produktLinje) {
		produktlinjer.add(produktLinje);
	}

	public static void removeProduktLinje(ProduktLinje produktLinje) {
		produktlinjer.remove(produktLinje);
	}

	public static void tømProduktLinjer() {
		produktlinjer.clear();
	}
	
	// -------Produkt---------------------------------------------

	public static ArrayList<Produkt> getProdukter() {
		return new ArrayList<Produkt>(produkter);
	}

	public static void addProdukt(Produkt produkt) {
		produkter.add(produkt);
	}

	public static void removeProdukt(Produkt produkt) {
		produkter.remove(produkt);
	}


	// -------Salg---------------------------------------------

	public static ArrayList<Salg> getSalgsenheder() {
		return new ArrayList<Salg>(salgsEnheder);
	}

	public static void addSalg(Salg salg) {
		if(!salgsEnheder.contains(salg)) {
			salgsEnheder.add(salg);
		}
	}

	public static void removeSalg(Salg salg) {
		salgsEnheder.remove(salg);
	}


	// -------PrisListe---------------------------------------------

	public static ArrayList<PrisListe> getPrislister() {
		return new ArrayList<PrisListe>(prislister);
	}

	public static void addPrisliste(PrisListe prisliste) {
		prislister.add(prisliste);
	}

	public static void removePrisliste(PrisListe prisliste) {
		prislister.remove(prisliste);
	}

	
	// -------ProcentvisRabat---------------------------------------------

	public static ArrayList<Rabat> getRabatter() {
		return new ArrayList<Rabat>(rabatter);
	}

	public static void addRabat(Rabat rabat) {
		rabatter.add(rabat);
	}

	public static void removeRabat(Rabat rabat) {
		rabatter.remove(rabatter);
	}
	
	
	// -------Betalingsform---------------------------------------------

	public static ArrayList<IBetalingsform> getBetalingsformer() {
		return new ArrayList<IBetalingsform>(betalingsformer);
	}

	public static void addBetalingsform(IBetalingsform Ibetalingsform) {
		betalingsformer.add(Ibetalingsform);
	}

	public static void removeBetalingsform(IBetalingsform Ibetalingsform) {
		betalingsformer.remove(Ibetalingsform);
	}


}

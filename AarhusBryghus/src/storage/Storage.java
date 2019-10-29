package storage;

import java.util.ArrayList;

import model.*;
import model.rabat.*;

public class Storage {

	//TODO Overvej andre collection-frameworks(datastrukturer)
	//TODO Er det en god idé at opbevare alle produktkategorierne i én liste
	private static ArrayList<Produkt> produkter = new ArrayList<>();
	private static ArrayList<Salg> salgsEnheder = new ArrayList<>();
	private static ArrayList<PrisListe> prislister = new ArrayList<>();
	private static ArrayList<Rabat> rabatter = new ArrayList<>();

	
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
		salgsEnheder.add(salg);
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

}

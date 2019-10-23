package storage;

import java.util.ArrayList;

import nyArkitektur.Produkt;
import nyArkitektur.Salg;

public class Storage {

	//TODO Overvej andre collection-frameworks(datastrukturer)
	//TODO Er det en god idé at opbevare alle produktkategorierne i én liste
	private static ArrayList<Produkt> produkter = new ArrayList<>();
	private static ArrayList<Salg> salgsEnheder = new ArrayList<>();

	
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

	
}

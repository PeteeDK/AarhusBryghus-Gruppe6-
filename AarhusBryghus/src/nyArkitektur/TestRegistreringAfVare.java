package nyArkitektur;

import java.util.Arrays;

import controller.Controller;
import storage.Storage;

public class TestRegistreringAfVare {

	public static void main(String[] args) {

		Produkt f1 = Controller.createFlaske("flaske", "klosterøl", 50, 36);
		Produkt f2 = Controller.createFlaske("Flaske", "Jazz Classic", 40, 25);
		Produkt s1 = Controller.createSpiritus("spiritus", "Spirit of Aarhus", 300, 300);
		
//		for(Produkt p : Controller.getFlasker()) {
//			System.out.println(p.toString());
//		}
		
		Controller.deleteProdukt(s1);
		
		for(Produkt p : Storage.getProdukter()) {
			System.out.println(p.toString());
		}
		
		
	}
}

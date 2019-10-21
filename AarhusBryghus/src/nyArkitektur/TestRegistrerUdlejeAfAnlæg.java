package nyArkitektur;

import controller.Controller;

public class TestRegistrerUdlejeAfAnlæg {

	public static void main(String[] args) {

		Produkt a = Controller.createAnlæg("Anlæg", "1-hane", false, 50, 10, 500);
//		Anlæg a = (Anlæg) Controller.createAnlæg("Anlæg", "1-hane", false, 50, 10, 500);
		
		System.out.println(((Anlæg)a).getStatus());
		
		((Anlæg)a).setAfleveret(true);
		
		System.out.println(((Anlæg)a).getStatus());
		
		
	}

}

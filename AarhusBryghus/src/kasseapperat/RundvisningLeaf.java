package kasseapperat;

import java.time.LocalDate;
import java.time.LocalTime;


public class RundvisningLeaf {
	
	private LocalDate dato; 
	private LocalTime tid; 
	private Boolean påbegyndtSalg = false; 
	private Boolean betalt = false; 
	private double aftenPris; 
	private double dagsPris; 
	private int studieRabat; 

}

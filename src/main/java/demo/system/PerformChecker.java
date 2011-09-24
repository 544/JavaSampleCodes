package demo.system;

import java.text.NumberFormat;

public class PerformChecker {
	
	public static void check(Logic logic) {
		long pre = System.nanoTime();

		logic.doIt();
		
		long post = System.nanoTime();
		NumberFormat nf = NumberFormat.getNumberInstance();
		System.out.println("[" +  nf.format((post - pre)/1000) + "] É  sec" );

	}

}

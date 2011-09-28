package demo.system;

import java.text.NumberFormat;


public class PerformCheckSample {
	
	public static void main(String[] args) {
		
		PerformChecker.check(new Logic() {
			
			@Override
			public void doIt() {
				// 計測対象の処理
				for (int i = 0; i < 100; i++) {
					System.out.println("hello");
				}
			}
		});

//		checkTime();
	}

	/**
	 * シンプルな時間計測
	 */
	@SuppressWarnings("unused")
	private static void checkTime() {
		long pre = System.nanoTime();

		// 計測対象の処理
		for (int i = 0; i < 100; i++) {
			System.out.println("hello");
		}
		
		long post = System.nanoTime();
		NumberFormat nf = NumberFormat.getNumberInstance();
		System.out.println("[" +  nf.format((post - pre)/1000) + "] μ sec" );
	}

}

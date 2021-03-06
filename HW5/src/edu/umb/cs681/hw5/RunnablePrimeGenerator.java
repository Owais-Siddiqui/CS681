package edu.umb.cs681.hw5;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {
	
	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		one_thread();
		two_threads();
		four_threads();
		eight_threads();
		sixteen_threads();
	}	
		
// one thread
		static void one_thread(){
		long start_Time = System.nanoTime();
		RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 2000000L);
		
		Thread t1 = new Thread(g1);
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {}
		
		//g1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		
		long primeNum = g1.getPrimes().size();
		System.out.println("------One Thread-----------");
		System.out.println("\n" + primeNum + " prime numbers found.");
		long end_Time = System.nanoTime();
		double duration = ((double)(end_Time - start_Time))/1000000000.0;
		System.out.println("It takes " + duration + " s to run with a single thread.");
	}	
// two threads
	static void two_threads(){
		long start_Time = System.nanoTime();
		RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 1000000L);
		RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(1000000L, 2000000L);
		
		Thread t1 = new Thread(g1);
		Thread t2 = new Thread(g2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		
		// g1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		
		long primeNum = g1.getPrimes().size() + g2.getPrimes().size();
		System.out.println("------Two threads-----------");
		System.out.println("\n" + primeNum + " prime numbers found.");
		long end_Time = System.nanoTime();
		double duration = ((double)(end_Time - start_Time))/1000000000.0;
		System.out.println("It takes " + duration + " s to run with 2 threads.");
	 }

//four threads
static void four_threads(){
	long start_Time = System.nanoTime();
	RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 500000L);
	RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(500000L, 1000000L);
	RunnablePrimeGenerator g3 = new RunnablePrimeGenerator(1000000L, 1500000L);
	RunnablePrimeGenerator g4 = new RunnablePrimeGenerator(1500000L, 2000000L);
	Thread t1 = new Thread(g1);
	Thread t2 = new Thread(g2);
	Thread t3 = new Thread(g3);
	Thread t4 = new Thread(g4);
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	try {
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	} catch (InterruptedException e) {}

	// g1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
	// g2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
	// g3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
	// g4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
	

	long primeNum = g1.getPrimes().size() + g2.getPrimes().size() + g3.getPrimes().size() + g4.getPrimes().size();
	System.out.println("\n" + primeNum + " prime numbers found.");
	long end_Time = System.nanoTime();
	double duration = ((double)(end_Time - start_Time))/1000000000.0;
	System.out.println("It takes " + duration + " s to run with 4 threads.");
  }




// eight threads
	static void eight_threads(){
		long start_Time = System.nanoTime();
		RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 250000L);
		RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(250000L, 500000L);
		RunnablePrimeGenerator g3 = new RunnablePrimeGenerator(500000L, 750000L);
		RunnablePrimeGenerator g4 = new RunnablePrimeGenerator(750000L, 1000000L);
		RunnablePrimeGenerator g5 = new RunnablePrimeGenerator(1000000L, 1250000L);
		RunnablePrimeGenerator g6 = new RunnablePrimeGenerator(1250000L, 1500000L);
		RunnablePrimeGenerator g7 = new RunnablePrimeGenerator(1500000L, 1750000L);
		RunnablePrimeGenerator g8 = new RunnablePrimeGenerator(1750000L, 2000000L);
		
		Thread t1 = new Thread(g1);
		Thread t2 = new Thread(g2);
		Thread t3 = new Thread(g3);
		Thread t4 = new Thread(g4);
		Thread t5 = new Thread(g5);
		Thread t6 = new Thread(g6);
		Thread t7 = new Thread(g7);
		Thread t8 = new Thread(g8);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
		} catch (InterruptedException e) {}

		// g1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g5.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g6.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g7.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g8.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

		long primeNum = g1.getPrimes().size() + g2.getPrimes().size() + g3.getPrimes().size() + g4.getPrimes().size() +
				g5.getPrimes().size() + g6.getPrimes().size() + g7.getPrimes().size() + g8.getPrimes().size();
				
		System.out.println("\n" + primeNum + " prime numbers found.");
		long end_Time = System.nanoTime();
		double duration = ((double)(end_Time - start_Time))/1000000000.0;
		System.out.println("It takes " + duration + " s to run with 8 threads.");
	}

// sixteen threads
	static void sixteen_threads(){
		long start_Time = System.nanoTime();
		RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 125000L);
		RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(125000L, 250000L);
		RunnablePrimeGenerator g3 = new RunnablePrimeGenerator(250000L, 375000L);
		RunnablePrimeGenerator g4 = new RunnablePrimeGenerator(375000L, 500000L);
		RunnablePrimeGenerator g5 = new RunnablePrimeGenerator(500000L, 625000L);
		RunnablePrimeGenerator g6 = new RunnablePrimeGenerator(625000L, 750000L);
		RunnablePrimeGenerator g7 = new RunnablePrimeGenerator(750000L, 875000L);
		RunnablePrimeGenerator g8 = new RunnablePrimeGenerator(875000L, 1000000L);
		RunnablePrimeGenerator g9 = new RunnablePrimeGenerator(1000000L, 1125000L);
		RunnablePrimeGenerator g10 = new RunnablePrimeGenerator(1125000L, 1250000L);
		RunnablePrimeGenerator g11 = new RunnablePrimeGenerator(1250000L, 1375000L);
		RunnablePrimeGenerator g12 = new RunnablePrimeGenerator(1375000L, 1500000L);
		RunnablePrimeGenerator g13 = new RunnablePrimeGenerator(1500000L, 1625000L);
		RunnablePrimeGenerator g14 = new RunnablePrimeGenerator(1625000L, 1750000L);
		RunnablePrimeGenerator g15= new RunnablePrimeGenerator(1750000L, 1875000L);
		RunnablePrimeGenerator g16 = new RunnablePrimeGenerator(1875000L, 2000000L);
		
		Thread t1 = new Thread(g1);
		Thread t2 = new Thread(g2);
		Thread t3 = new Thread(g3);
		Thread t4 = new Thread(g4);
		Thread t5 = new Thread(g5);
		Thread t6 = new Thread(g6);
		Thread t7 = new Thread(g7);
		Thread t8 = new Thread(g8);
		Thread t9 = new Thread(g9);
		Thread t10 = new Thread(g10);
		Thread t11 = new Thread(g11);
		Thread t12 = new Thread(g12);
		Thread t13 = new Thread(g13);
		Thread t14 = new Thread(g14);
		Thread t15 = new Thread(g15);
		Thread t16 = new Thread(g16);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		t15.start();
		t16.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
			t9.join();
			t10.join();
			t11.join();
			t12.join();
			t13.join();
			t14.join();
			t15.join();
			t16.join();
		} catch (InterruptedException e) {}

		// g1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g5.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g6.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g7.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g8.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g9.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g10.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g11.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g12.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g13.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g14.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g15.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		// g16.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );

		long primeNum = g1.getPrimes().size() + g2.getPrimes().size() + g3.getPrimes().size() + g4.getPrimes().size() +
				g5.getPrimes().size() + g6.getPrimes().size() + g7.getPrimes().size() + g8.getPrimes().size() +
				g9.getPrimes().size() + g10.getPrimes().size() + g11.getPrimes().size() + g12.getPrimes().size() +
				g13.getPrimes().size() + g14.getPrimes().size() + g15.getPrimes().size() + g16.getPrimes().size()
				;
		
		System.out.println("------16 threads-----------");
		System.out.println("\n" + primeNum + " prime numbers found.");
		long end_Time = System.nanoTime();
		double duration = ((double)(end_Time - start_Time))/1000000000.0;
		System.out.println("It takes " + duration + " s to run with 16 threads.");
	}
}

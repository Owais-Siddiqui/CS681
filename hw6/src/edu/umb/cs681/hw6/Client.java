package edu.umb.cs681.hw6;

import java.util.LinkedList;

public class Client {
	public static void main(String[] args) {
		System.out.println("Factorization of 26");
		RunnableCancellablePrimeFactorizer runnable = new RunnableCancellablePrimeFactorizer(26, 2, 26);
		Thread thread = new Thread(runnable);
		System.out.println("Thread Number " + thread.getId() + 
			" performs factorization from " + runnable.getFrom() + "To " + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + runnable.getPrimeFactors() + "\n");
		
		System.out.println("Factorization of 84");
		runnable = new RunnableCancellablePrimeFactorizer(84, 2, 84);
		thread = new Thread(runnable);
		System.out.println("Thread Number " + thread.getId() + 
			" performs factorization from " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + runnable.getPrimeFactors() + "\n");

		System.out.println("Factorization of 2489");
		runnable = new RunnableCancellablePrimeFactorizer(2489, 2, 2489);
		thread = new Thread(runnable);
		System.out.println("Thread Number " + thread.getId() + 
			" performs factorization from " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + runnable.getPrimeFactors() + "\n");	

		System.out.println("Factorization of 2489, but canncel immediately");
		runnable = new RunnableCancellablePrimeFactorizer(2489, 2, 2489);
		thread = new Thread(runnable);
		System.out.println("Thread Number " + thread.getId() + 
			" performs factorization from " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		runnable.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + runnable.getPrimeFactors() + "\n");	
	}
}

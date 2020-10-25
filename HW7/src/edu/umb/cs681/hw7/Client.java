package edu.umb.cs681.hw7;

import java.util.LinkedList;

public class Client {
	public static void main(String[] args) {
		System.out.println("Factorization of 28");
		RunnableCancellablePrimeFactorizer runnable = new RunnableCancellablePrimeFactorizer(28, 2, 28);
		Thread thread = new Thread(runnable);
		System.out.println("Thread Number : " + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result : " + runnable.getPrimeFactors() + "\n");
		
		// Factorization of 84
		System.out.println("Factorization of 64");
		runnable = new RunnableCancellablePrimeFactorizer(64, 2, 64);
		thread = new Thread(runnable);
		System.out.println("Thread Number : " + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result : " + runnable.getPrimeFactors() + "\n");
		
		System.out.println("Factorization of 4489");
		runnable = new RunnableCancellablePrimeFactorizer(4489, 2, 4489);
		thread = new Thread(runnable);
		System.out.println("Thread Number : " + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result : " + runnable.getPrimeFactors() + "\n");	

		System.out.println("Factorization of 2489, but canncels immediately and produces no result");
		runnable = new RunnableCancellablePrimeFactorizer(4489, 2, 4489);
		thread = new Thread(runnable);
		System.out.println("Thread Number : " + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + " To " + runnable.getTo());
		thread.start();
		runnable.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Result : " + runnable.getPrimeFactors() + "\n");	
	}
}

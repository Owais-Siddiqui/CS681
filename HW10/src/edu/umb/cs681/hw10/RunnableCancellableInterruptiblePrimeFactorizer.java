package edu.umb.cs681.hw10;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{
	
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}finally {
			lock.unlock();
		}
	}
	
	@Override
	public void generatePrimeFactors() {
		long divisor = 2;
	    while( dividend != 1 && divisor <= to ){
	    	lock.lock();
	    	try {
	    		if(done) {
					System.out.println("Stopped.");
					this.factors.clear();
	    			break;
				}
			    if(dividend % divisor == 0) {
			        factors.add(divisor);
			        dividend /= divisor;
			    }else {
			    	if(divisor==2){ divisor++; }
			    	else{ divisor += 2; }
			    	
			    }
	    	}finally {
	    		lock.unlock();
			}
			try {
				System.out.println("factorizer thread sleeping for 3s");
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				System.out.println("Interrupted");
				System.out.println(e.toString());
				continue;
			}

		}
	}
	
	public static void main(String[] args) {
		System.out.println("Prime Factorizing on 136, and interrupt immediately");
		RunnableCancellableInterruptiblePrimeFactorizer factorizer = new RunnableCancellableInterruptiblePrimeFactorizer(136, 2, 136);
		Thread thread = new Thread(factorizer);
		thread.start();
		try {
			System.out.println("main thread sleeping for 1s.");
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(e.toString());
		}
		factorizer.setDone();
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

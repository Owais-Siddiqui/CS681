package edu.umb.cs681.hw10;

import java.util.LinkedList;

public class PrimeFactorizer {
	protected long dividend, from, to;
	protected LinkedList<Long> factors = new LinkedList<Long>();
	
	public PrimeFactorizer(long dividend){
		if(dividend >= 2){
			this.dividend = dividend;
			this.from = 2;
			this.to = dividend;
		}else{
			throw new RuntimeException("dividend must be more than or equal to 2. dividend : " + dividend);
		}
	}
	
	public void generatePrimeFactors() {
		long divisor = 2;
	    while( dividend != 1 && divisor <= to ){
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
		    	
		    }
		}
	}
	
	public LinkedList<Long> getPrimeFactors(){
		return factors;
	}

	public static void main(String[] args) {
		System.out.print("Prime factors of 16: ");
		PrimeFactorizer fac = new PrimeFactorizer(16);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 19: ");
		fac = new PrimeFactorizer(19);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 131: ");
		fac = new PrimeFactorizer(131);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 64: ");
		fac = new PrimeFactorizer(64);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 125: ");
		fac = new PrimeFactorizer(125);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());		
	}

}

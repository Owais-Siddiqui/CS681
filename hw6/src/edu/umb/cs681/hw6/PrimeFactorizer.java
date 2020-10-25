package edu.umb.cs681.hw6;

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
			throw new RuntimeException("dividend must be >= 2. dividend==" + dividend);
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
		System.out.print("Prime factors of 12 : ");
		PrimeFactorizer fac = new PrimeFactorizer(12);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 19: ");
		fac = new PrimeFactorizer(19);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 135: ");
		fac = new PrimeFactorizer(135);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 184: ");
		fac = new PrimeFactorizer(184);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 125: ");
		fac = new PrimeFactorizer(125);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 4489: ");
		fac = new PrimeFactorizer(4489);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
		System.out.print("Prime factors of 2633: ");
		fac = new PrimeFactorizer(2633);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
		
	}

}

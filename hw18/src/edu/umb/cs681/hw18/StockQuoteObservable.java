package edu.umb.cs681.hw18;


public class StockQuoteObservable extends ThreadSafeObservable {
	
	public void setQuote() {
		this.setChanged();
	}
}


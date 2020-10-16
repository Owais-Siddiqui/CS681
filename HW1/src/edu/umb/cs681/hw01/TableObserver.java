package edu.umb.cs681.hw01;
	
public class TableObserver implements Observer {

	public void update(Observable obs,Object arg) {
		if(arg instanceof DJIAEvent) {
			DJIAEvent dJIAEvent = (DJIAEvent) arg;
			System.out.println("This is an instance of a DJIAEvent class.\n");
			System.out.println("DJIA:" +dJIAEvent.getDjia() +" \n");
		}else if(arg instanceof StockEvent) {
			StockEvent stockevent = (StockEvent) arg;
			System.out.println("This is an instance of a StockEvent class.\n");
			System.out.println(stockevent.getTicker()+ "  "+ stockevent.getQuote()+" \n");
		}
	}
}


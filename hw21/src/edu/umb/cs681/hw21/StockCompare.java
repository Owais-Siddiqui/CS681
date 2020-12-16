package edu.umb.cs681.hw21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class StockCompare {
	public static void main(String args[]) throws ParseException {
		String sDate = "12 16, 2020";
		SimpleDateFormat formatter = new SimpleDateFormat("MM dd, yyyy");
		Date date = formatter.parse(sDate);  
		ArrayList<Stock> stocks = new ArrayList<Stock>(
				Arrays.asList(
						new Stock("IBM", 231.14f, 234.34f, date),
						new Stock("Tesla", 18.78f, 218.85f, date),
						new Stock("GM", 3260.00f, 3280.39f, date),
						new Stock("Lenovo", 158.16f, 160.92f, date)));
		System.out.println("input stock data--------------: \n");
		System.out.println("IBM with open price 277.14 closed price 285.34 on date 3 10, 2020");
		System.out.println("Tesla with open price 8.78 closed price 8.85 on date 3 10, 2020");
		System.out.println("GM with open price 1260.00 closed price 1280.39 on date 3 10, 2020");
		System.out.println("Lenovo with open price 158.16 closed price 160.92 on date 3 10, 2020\n");
		System.out.println("Max increase rate Method result --------: ");
		Float maxIncreaseRate = stocks.stream()
				.parallel()
				.map((Stock stock) -> (stock.getClosePrice()-stock.getOpenPrice())*100/stock.getOpenPrice())
				.reduce(Float.MIN_VALUE, (result, stockRate) -> {
					if(stockRate > result) return stockRate;
					else return result;
				}, (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : F_Result = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return (finalResult > interMediateResult)? finalResult:interMediateResult;});
		System.out.println("Max Increase rate is " + maxIncreaseRate);
		System.out.println("Min increase rate Method result --------: ");
		Float minIncreaseRate = stocks.stream()
				.parallel()
				.map((Stock stock) -> (stock.getClosePrice()-stock.getOpenPrice())*100/stock.getOpenPrice())
				.reduce(Float.MAX_VALUE, (result, stockRate) -> {
					if(stockRate < result) return stockRate;
					else return result;
				}, (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : f_Result = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return (finalResult < interMediateResult)? finalResult:interMediateResult;});
		System.out.println("Min Increase rate is " + minIncreaseRate);
		System.out.println("Count the number of stocks that have increase rate bigger than 2% method result --------: ");
		Integer count = stocks.stream()
				.parallel()
				.map((Stock stock) -> ((stock.getClosePrice()-stock.getOpenPrice())*100/stock.getOpenPrice()) > 2 ? 1 : 0)
				.reduce(0, (result, existed) -> {
					return result + existed;
				}, (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : F_Result = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return finalResult+interMediateResult;});
		System.out.println("Number of stocks with increase rate bigger than 2% is " + count);
	}
	
}

package edu.umb.cs681.hw20;

import java.util.ArrayList;
import java.util.Arrays;

public class CarCompare {
	static ArrayList<Car> cars = new ArrayList<Car>(
			Arrays.asList(
					new Car(30000, "Tesla", "ModelX"),
					new Car(24000, "Toyota", "Prado"),
					new Car(22000, "BMW", "X-6"),
					new Car(45000, "Merc", "G65"),
					new Car(51000, "Audi", "A4")));
	public static void main(String args[]) {
		System.out.println("Cars list with value:\n");
		System.out.println("Tesla with price 30000");
		System.out.println("Toyota with price 24000");
		System.out.println("BMW with price 22000");
		System.out.println("Merc with price 45000\n");
		System.out.println("Audi with price 51000\n");
		System.out.println("Min Price Method result --------: ");
		Integer minPrice = cars.stream()
				.parallel()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, carPrice)->{
				if(result==0) return carPrice;
				else if(carPrice < result) return carPrice; else return result;},
					    (finalResult, interMediateResult)->{
					    	System.out.println(Thread.currentThread().getName() + " : F_Result = " + finalResult + "; interMediateResult = " + interMediateResult);
					    	return (finalResult < interMediateResult)? finalResult:interMediateResult;
					    });
		System.out.println("Min price: " + minPrice);
		System.out.println("-------- Max Price Method result --------: ");
		Integer maxPrice = cars.stream()
				.map((Car car) -> car.getPrice())
				.parallel()
				.reduce(0, (result, carPrice) -> {
					if(result == 0) return carPrice;
					else if(carPrice >= result) return carPrice;
					else return result;
				}, 					    (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : F_Result = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return (finalResult > interMediateResult)? finalResult:interMediateResult;
			    });
		System.out.println("Max price: " + maxPrice);
		System.out.println("---------- Count Method result --------: ");
		Integer count = cars.stream()
				.parallel()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, car) -> {
					if(car != null) return ++result;
					return result;
				},										(finalResult,intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : F_Result = " + finalResult + "; interMediateResult = " + intermediateResult);
					return finalResult + intermediateResult;
				});
		System.out.println("Count : " + count);
		System.out.println("--------- Count number of models --------: ");
		Integer numberOfModel = cars.stream()
				.parallel()
				.map((Car car) -> car.getModel())
				.distinct()
				.reduce(0, (result, model) -> {
					return ++result;
				}, (finalResult,intermediateResult) -> {
					System.out.println(Thread.currentThread().getName() + " : F_Result = " + finalResult + "; interMediateResult = " + intermediateResult);
					return finalResult+intermediateResult;
				});
		
		System.out.println("The Number of Models: " + numberOfModel);
	}
			
}

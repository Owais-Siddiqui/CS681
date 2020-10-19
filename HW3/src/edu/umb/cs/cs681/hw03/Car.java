package edu.umb.cs681.hw03;

import java.util.ArrayList;

public class Car {
	private int price, year, mileage;
	private String model;
	
	public Car(String model, int mileage, int price, int year) {
		this.model = model;
		this.mileage = mileage;
		this.price = price;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getMileage() {
		return mileage;
	}

	public int getPrice() {
		return price;
	}
	
	public int getYear() {
		return year;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Car> cars = new ArrayList<Car>();
		
		cars.add(new Car("Tesla", 20000, 10000, 2020));
		cars.add(new Car("BMW", 3000, 1050000, 2015));
		cars.add(new Car("Lambo", 100, 50000, 2019));
		cars.add(new Car("Honda", 2000, 3000, 2017));
		cars.add(new Car("Ferrari", 1000, 75000, 2013));
		cars.add(new Car("Ford", 1200, 20750, 2018));
		
		Integer minPrice = cars.stream()
				.map((Car car)-> car.getPrice())
				.reduce(0, (result, carPrice)->{
					if(result==0) return carPrice;
					else if(carPrice < result) return carPrice;
					else return result;} );
		
		Integer maxPrice = cars.stream()
				.map((Car car)-> car.getPrice())
				.reduce(0, (result, carPrice)->{
					if(result==0) return carPrice;
					else if(carPrice > result) return carPrice;
					else return result;} );
				
		Integer minYear = cars.stream()
				.map((Car car)-> car.getYear())
				.reduce(0, (result, carYear)->{
					if(result==0) return carYear;
					else if(carYear < result) return carYear;
					else return result;} );
				
		Integer maxMileage = cars.stream()
				.map((Car car)-> car.getMileage())
				.reduce(0, (result, carMileage)->{
					if(result==0) return carMileage;
					else if(carMileage > result) return carMileage;
					else return result;} );

		Integer maxYear = cars.stream()
				.map((Car car)-> car.getYear())
				.reduce(0, (result, carYear)->{
					if(result==0) return carYear;
					else if(carYear > result) return carYear;
					else return result;} );
						
		Integer minMileage = cars.stream()
				.map((Car car)-> car.getMileage())
				.reduce(0, (result, carMileage)->{
					if(result==0) return carMileage;
					else if(carMileage < result) return carMileage;
					else return result;} );
							
		Integer count = cars.stream()
				.map((Car car)-> car.getPrice())
				.reduce(0, (result, carPrice)->{
					if(carPrice < 5000) result++;
	    			return result;} );
		    				
		System.out.println("Min Price: " + minPrice);
		System.out.println("Max Price: " + maxPrice);
		System.out.println();
		System.out.println("Min Year: " + minYear);
		System.out.println("Max Year: " + maxYear);
		System.out.println();
		System.out.println("Min Mileage: " + minMileage);
		System.out.println("Max Mileage: " + maxMileage);
		System.out.println();
		System.out.println("Number of cars that cost less than $5000: " + count);
	}
}

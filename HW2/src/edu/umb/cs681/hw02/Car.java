package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

	private String model, make;
	private int mileage, year;
	private int price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, int price) {
		this.model = model;
		this.make = make;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public void setDominationCount(List<Car> cars) {
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public static void main(String args[]) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Tesla", "X3", 20, 2018, 10000));
		cars.add(new Car("BMW", "X6", 100, 2019, 20000));
		cars.add(new Car("Ferrari", "f60", 200, 2015, 50000));
		cars.add(new Car("Totoya", "Prado", 50, 2020, 15000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

		List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());

		List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage))
				.collect(Collectors.toList());

		List<Car> sortByDominationCount = cars.stream().sorted(Comparator.comparing(Car::getDominationCount))
				.collect(Collectors.toList());

		System.out.println("Sorting by Price Ascending");
		sortByPrice.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getPrice()));

		System.out.println("Sorting by Mileage Ascending");
		sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getMileage()));

		System.out.println("Sorting by Year Ascending");
		sortByYear.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getYear()));

		System.out.println("Sorting by Domination Count Ascending");
		sortByDominationCount.forEach((Car car) -> System.out.println(car.getMake() + ":" + car.getDominationCount()));
	}
}
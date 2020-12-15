package edu.umb.cs681.hw12;

public class Client implements Runnable {

	private Address addr1 = new Address("25th Street 1at ave", "Dubai", "MA", 02125);
	private Address addr2 = new Address("1st Street", "New York", "NY", 1234);
	private Customer customer1 = new Customer(addr1);
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Client());
		Thread t2 = new Thread(new Client());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	@Override
	public void run() {
		System.out.println("Get customer's address:");
		customer1.getAddress();
		System.out.println("Set customer's address to new addr2:");
		customer1.setAddress(addr2);
		System.out.println("Set customer's address back using change");
		customer1.setAddress(customer1.getAddress().change("25th Street", "Dubai City", "MA State", 1234));
	}
}

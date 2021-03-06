package edu.umb.cs681.hw12;

public final class Address {
	private final String street, city, state;
	private final int zipCode;
	
	// constructor
	public Address(String street, String city, String state, int zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	// getter methods
	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZipCode() {
		return zipCode;
	}

	// check equals
	public boolean equals(Address address) {
		if(address == this) {
			return true;
		}
		if(!(address instanceof Address)) {
			return false;
		}
		Address tmp = (Address) address;
		return this.city.equals(tmp.getCity()) 
				&& this.street.equals(tmp.getStreet()) 
				&& this.state.equals(tmp.getState()) 
				&& Integer.compare(this.zipCode, tmp.getZipCode()) == 0;
	}
	
	// convert to string
	public String toString() {
		return street + " " + city + " " + state + " " + zipCode;
	}

	// update
	public Address change(String street, String city, String state, int zipCode) {
		return new Address(street, city, state, zipCode);
	}
	
}

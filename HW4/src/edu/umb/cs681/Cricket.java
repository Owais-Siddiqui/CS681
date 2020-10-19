package edu.umb.cs681.hw04;

import java.util.ArrayList;

public class Cricket {
	private int innings, runs, wickets;
	private String name;
	
	public Cricket(String name, int innings, int runs, int wickets) {
		this.name = name;
		this.innings = innings;
		this.runs = runs;
		this.wickets = wickets;
	}
	
	public String getname() {
		return name;
	}
	
	public int getInnings() {
		return innings;
	}

	public int getRuns() {
		return runs;
	}
	
	public int getWickets() {
		return wickets;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Cricket> cricket = new ArrayList<Cricket>();
		
		cricket.add(new Cricket("Rashid Khan", 900, 1230, 1000));
		cricket.add(new Cricket("David Warner", 1100, 12230, 10));
		cricket.add(new Cricket("Kane Williamson", 998, 10002, 1));
		cricket.add(new Cricket("Virat Kholi", 1200, 121230, 100));

		Integer minWickets = cricket.stream()
				.map((Cricket c1)-> c1.getWickets())
				.reduce(0, (result, playerWickets)->{
					if(result==0) return playerWickets;
					else if(playerWickets < result) return playerWickets;
					else return result;} );
		
		Integer maxWickets = cricket.stream()
				.map((Cricket c1)-> c1.getWickets())
				.reduce(0, (result, playerWickets)->{
					if(result==0) return playerWickets;
					else if(playerWickets > result) return playerWickets;
					else return result;} );

		Integer minRuns = cricket.stream()
				.map((Cricket c1)-> c1.getRuns())
				.reduce(0, (result, playerRuns)->{
					if(result==0) return playerRuns;
					else if(playerRuns < result) return playerRuns;
					else return result;} );
				

		Integer maxRuns = cricket.stream()
				.map((Cricket c1)-> c1.getRuns())
				.reduce(0, (result, playerRuns)->{
					if(result==0) return playerRuns;
					else if(playerRuns > result) return playerRuns;
					else return result;} );

							
		Integer count = cricket.stream()
				.map((Cricket c1)-> c1.getWickets())
				.reduce(0, (result, playerWickets)->{
					if(playerWickets < 500) result++;
	    			return result;} );
		    				
		System.out.println("Min Runs: " + minRuns);
		System.out.println("Max Runs: " + maxRuns);
		System.out.println();
		System.out.println("Min Wickets: " + minWickets);
		System.out.println("Max Wickets: " + maxWickets);
		System.out.println();
		System.out.println("Number of players with less than 500 wickets: " + count);
	}
}

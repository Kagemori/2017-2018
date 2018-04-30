/*
 * Keith Estrella
 * 
 * This program makes use of the IO java class for reading txt files.
 * The program reads a txt file and converts the read inputs into individual objects which are then put into an array and printed in a formatted report.
 * The code contains two classes in one file.
 */

import java.io.*;
import java.util.*;

public class estrekei_Program7{
	public static void main(String[] args) throws IOException {
		File file = new File("program7.txt");
		Scanner reader = new Scanner(file);
		
		Animals [] alist = new Animals[reader.nextInt()];
		
		String aname = "";
		int ayear = 0;
		double abalance = 0.0;
		String aspecies = "";
		int count = 0;
		
		while(reader.hasNext()) {
			aname = reader.next();
			ayear = reader.nextInt();
			abalance = reader.nextDouble();
			aspecies = reader.next();
			alist[count] = new Animals(aname, ayear, abalance, aspecies);
			count++;
		}
		
		System.out.printf("\t\t\t%-6s\n", "REPORT");
		System.out.printf("\t\t\t%-6s\n", "======");
		System.out.println();
		System.out.printf("%-9s\t%-11s\t%-8s\t%-9s\n", "Owner","Birth Year","Balance","Species");
		System.out.printf("%-9s\t%-11s\t%-8s\t%-9s\n", "=====","==========","=======","=======");
		for(int i = 0; i < alist.length; i++) {
			System.out.printf("%-9s\t%-11d\t%-8.1f\t%-9s\n",alist[i].getName(),alist[i].getYear(),alist[i].getBalance(),alist[i].getSpecies());
		}
	}
}

class Animals{
	private String name;
	private int year;
	private double balance;
	private String species;
	
	public Animals() {
		name = "";
		year = 0;
		balance = 0.0;
		species = "";
	}
	public Animals(String name, int year, double balance, String species) {
		this.name = name;
		this.year = year;
		this.balance = balance;
		this.species = species;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getName() {
		return this.name;
	}
	public int getYear() {
		return this.year;
	}
	public double getBalance() {
		return this.balance;
	}
	public String getSpecies() {
		return this.species;
	}
}
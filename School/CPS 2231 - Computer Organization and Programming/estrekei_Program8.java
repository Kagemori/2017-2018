/*
 * Keith Estrella
 * Planning time: 25 mins
 * Coding time: ~2 hours
 * Testing time: 5-10 mins
 * Debugging: 25-35 mins
 * 
 * The program reads a formatted text file and prints it out in a formatted list sorted by Customer ID.
 * NOTE: The program contains only the methods needed for the program to run as such setters are not added to the classes.
 */

import java.util.*;
import java.io.*;

public class estrekei_Program8 {

	public static void main(String[] args)throws IOException {
		File file = new File("program8.txt");
		Scanner reader = new Scanner(file);
		
		int listsize = reader.nextInt();
		Customer [] list = new Customer[listsize];
		
		String name = "";
		int id = 0;
		double balance = 0.0;
		String email = "";
		int count = 0;
		
		while(reader.hasNext()) {
			name = reader.next();
			id = reader.nextInt();
			balance = reader.nextDouble();
			email = reader.next();
			
			if(reader.hasNextDouble()) {
				double tax = reader.nextDouble();
				Taxable customer = new Taxable(name,id,balance,email,tax);
				list[count] = customer;
				count++;
			} else {
				String type = reader.next();
				NonTaxable customer = new NonTaxable(name,id,balance,email,type);
				list[count] = customer;
				count++;
			}
		}
		
		Arrays.sort(list);
		
		int pgnum = 1;
		int counter = 0;
		System.out.printf("\t\t\t%-40s\t\t%-6s%-2d\n", "Office Supplies Inc Customer Report","Page: ",pgnum);
		System.out.printf("\t\t\t%-50s\n", "===================================");
		System.out.println();
		
		System.out.printf("%-18s\t%-4s\t%-25s\t\t%10s\t%12s\t%9s\n", "Customer","ID","Email Address","Balance","Tax Type", "Tax Amount");
		System.out.printf("%-18s\t%-4s\t%-25s\t\t%10s\t%12s\t%9s\n", "========","==","=============","=======","========", "==========");
		while(counter < pgnum*45 && counter < listsize) {
			if(list[counter] instanceof Taxable) {
				System.out.printf("%-18s\t%-4d\t%-25s\t\t%12.2f\t%12s\t%9.2f\n",list[counter].getName(),list[counter].getID(),list[counter].getEmail(),list[counter].getBalance(),((Taxable)list[counter]).getTaxType(),((Taxable)list[counter]).getTax());
			}else {
				System.out.printf("%-18s\t%-4d\t%-25s\t\t%12.2f\t%12s\n",list[counter].getName(),list[counter].getID(),list[counter].getEmail(),list[counter].getBalance(),((NonTaxable)list[counter]).getTaxType());
			}
			counter++;
			if(counter == pgnum*45) {
				pgnum++;
				System.out.println();
				System.out.printf("\t\t\t%-40s\t\t%-6s%-2d\n", "Office Supplies Inc Customer Report","Page: ",pgnum);
				System.out.printf("\t\t\t%-50s\n", "===================================");
				System.out.println();
				System.out.printf("%-18s\t%-4s\t%-25s\t\t%10s\t%12s\t%9s\n", "Customer","ID","Email Address","Balance","Tax Type", "Tax Amount");
				System.out.printf("%-18s\t%-4s\t%-25s\t\t%10s\t%12s\t%9s\n", "========","==","=============","=======","========", "==========");
			}
		}
	}
}

class Customer implements Comparable<Customer> {
	private String name;
	private int id;
	private double balance;
	private String email;
	
	public Customer(){
		name = "";
		id = 0;
		balance = 0.0;
		email = "";
	}
	public Customer(String name, int id, double balance, String email) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return name + " " + id + " " + balance + " " + email;
	}
	
	public int compareTo(Customer compareCustomer) {
		int compareID = ((Customer)compareCustomer).getID();
		return this.id - compareID;
	}
}

class Taxable extends Customer{
	private String taxtype;
	private double tax;
	
	public Taxable() {
		super();
		this.taxtype = "tax liable";
		this.tax = 0.0;
	}
	public Taxable(String name, int id, double balance, String email, double tax) {
		super(name, id, balance, email);
		this.taxtype = "tax liable";
		this.tax = tax;
	}
	
	public String getTaxType() {
		return taxtype;
	}
	public double getTax() {
		return tax;
	}
	
	public String toString() {
		return super.toString() + " " + taxtype + " " + tax;
	}
}

class NonTaxable extends Customer{
	private String taxtype;
	
	public NonTaxable() {
		super();
		this.taxtype = "";
	}
	public NonTaxable(String name, int id, double balance, String email, String taxtype) {
		super(name, id, balance, email);
		this.taxtype = taxtype;
	}
	
	public String getTaxType() {
		return taxtype;
	}
	
	public String toString() {
		return super.toString() + " " + taxtype;
	}
}
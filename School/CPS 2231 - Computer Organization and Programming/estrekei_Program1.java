package estrekei_Program1;

/*
 * Keith Estrella
 * The program takes three user inputs, starting tuition, starting year and yearly percent increase.
 * The program then calculates and prints the yearly tuition with respect to the percent increase.
 */

import java.util.Scanner;

public class estrekei_Program1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the starting tuition: ");
		double tuition = input.nextDouble();
		double newtuition = tuition;
		
		System.out.print("Enter the starting year: ");
		int startyear = input.nextInt();
		int year = startyear;
		
		System.out.print("Enter the yearly percent increase: ");
		int rate = input.nextInt();
		
		System.out.printf("Tuition this year (" + year + ") is $%,7.00f"+". Tuition will increase by " + (double)rate + "%% each year.", tuition);
		System.out.println();
		
		for(int i = 0; i < 10; i++) {
			year++;
			newtuition += (newtuition * (rate/100.0));
			System.out.printf("Tuition this year (" + year + ") is $%,7.00f.", newtuition);
			System.out.println();
		}
		System.out.printf("The total increase over 10 years is $%,7.00f.", (newtuition-tuition));
	}
}

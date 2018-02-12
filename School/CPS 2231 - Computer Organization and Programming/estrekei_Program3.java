

/*
 * Keith Estrella
 * Runs a program that allows user to input values and keeps track of occurences of 
 * the same number and prints all numbers inputted with their respective amount.
 */

import java.util.Scanner;

public class estrekei_Program3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int [] valueCounter = new int[100];
		
		System.out.println("Enter a number between 1 and 100");
		int x = input.nextInt();
		
		while(x != 0 || x > 100) {
			valueCounter[x-1]++;
			System.out.println("Enter a number between 1 and 100");
			x = input.nextInt();
		}
		
		for(int i = 0; i < valueCounter.length; i++) {
			if(valueCounter[i] != 0) {
				printValue(i+1,valueCounter[i]);
			}
		}
	}
	
	public static void printValue(int index, int occur) {
		System.out.println(index + " occurs "+occur+" times.");
	}
}

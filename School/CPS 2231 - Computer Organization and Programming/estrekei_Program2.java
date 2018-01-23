package estrekei_Program2;

/*
 * Keith Estrella
 * The program takes user input and generates 3 triangles of different orientations using nested loops and the size of the triangle is based on the user input.
 */

import java.util.Scanner;

public class estrekei_Program2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of rows: ");
		int rows = input.nextInt();
		
		printTriangle1(rows);
		printTriangle2(rows);
		printTriangle3(rows);
	}
	
	public static void printTriangle1(int rows) {
		System.out.println("Printing Triangle 1");
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printTriangle2(int rows) {
		System.out.println("Printing Triangle 2");
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < rows-i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printTriangle3(int rows) {
		System.out.println("Printing Triangle 3");
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int x = 0; x < rows-i; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

/*
 * Keith Estrella
 * This program prompts the user to enter a 4x4 matrix of integers, the program then runs a method
 * which checks if it is an  arrowhead matrix, where there are no 0s in the first column, row and diagonal.
 */

import java.util.Scanner;

public class estrekei_Program5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int [][] matrix = new int[4][4];
		
		System.out.println("Please input integers for matrix:");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(input.hasNextInt()) {
					matrix[i][j] = input.nextInt();
				}
			}
		}
		
		System.out.println();
		printArray(matrix);
		if(isArrowHead(matrix) == true) {
			System.out.print("The matrix is an Arrowhead Matrix");
		}else{
			System.out.print("The matrix is not an Arrowhead Matrix");
		}
	}
	
	public static boolean isArrowHead(int [][] matrix) {
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0 || matrix[i][0] == 0 || matrix[i][i] == 0) {
				return false;
			}
		}
		
		//Check the areas where it is supposed to be 0 (Split so it isn't horizontally lengthy)
		if(matrix[2][1] != 0 || matrix[3][1] != 0 || matrix[3][2] != 0) {
			return false;
		}
		if(matrix[1][2] != 0 || matrix[1][3] != 0 || matrix[2][3] != 0) {
			return false;
		}
		
		return true;
	}
	
	public static void printArray(int [][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}

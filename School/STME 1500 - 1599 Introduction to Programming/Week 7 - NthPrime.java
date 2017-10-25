package nthprime;

import java.util.Scanner;

public class NthPrime {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String primelist = "";
        boolean search = true;
        
        // Interactive Search Function
        while(search){
            // Initialize variables / Counters
            int primetotal = 0;
            int number = 1;
            
            // Provide user input
            System.out.print("Input Nth Prime Term: ");
            int Nth = input.nextInt();
            
            // Generates primes till requested prime number term
            while(primetotal < Nth){
                number++;
                if(isPrime(number)){
                    primelist = primelist + number + ", ";
                    primetotal++;
                }
            }
            
            // Display prime number with Nth term indicator
            System.out.println(primelist);
            System.out.println("Prime Number " + Nth + " is " + number);
            
            // Ask to continue making additional searches
            System.out.print("Would you like to continue? Input Y = 1 || N = 0: ");
            int cont = input.nextInt();
            
            if(cont == 0){
                search = false;
            }else if(cont > 1 || cont < 0){
                System.out.println("Error, ending search.");
                search = false;
            }
            System.out.println();
        }
    }
    
    //Separate Method To Check For Primeness
    public static boolean isPrime(int num){
        if(num == 0 || num ==1) //NOT PRIME
            return false;
        if(num == 2) //First Prime
            return true;
        if(num % 2 == 0) //NOT PRIME
            return false;
        for(int i = 2; i < Math.sqrt(num) + 1; i++) //STILL NOT PRIME
            if(num % i == 0)
                return false;
        return true;
    }
}

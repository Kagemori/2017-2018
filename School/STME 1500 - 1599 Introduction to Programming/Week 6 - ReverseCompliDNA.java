package reversecomplidna;

import java.util.Scanner;

public class ReverseCompliDNA {
    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
       
        // Provide user input
        System.out.print("Write DNA Sequence:");
        String dna = input.next();
        String revdna = "";
        
        // Reverse DNA sequence
        for(int i = 1; i <= dna.length(); i++) { 
            revdna = revdna + dna.charAt(dna.length() - i);
        } 
        System.out.println("Reverse DNA:" + revdna);
        
        // Replace reverse DNA sequence with complimentary nucleotides
        String compliDNA = revdna;
        compliDNA = compliDNA.replaceAll("A", "Y");
        compliDNA = compliDNA.replaceAll("T", "A");
        compliDNA = compliDNA.replaceAll("Y", "T");
        compliDNA = compliDNA.replaceAll("G", "X");
        compliDNA = compliDNA.replaceAll("C", "G");
        compliDNA = compliDNA.replaceAll("X", "C");
        
        System.out.println("Reverse Complimentary DNA: " + compliDNA);
    }
}

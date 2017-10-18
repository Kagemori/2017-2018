package dnamotif;

import java.util.Scanner;

public class DNAMotif {

    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);
       
        // Provide user input
        System.out.print("Write DNA Sequence: ");
        String dna = input.next();
        System.out.print("Input Motif: ");
        String motif = input.next();
        
        // Initialize String for index results
        String rankindex = "";
        
        // Initialize indexOf used to search for motif
        int rank = dna.indexOf(motif);

        // Loop that searches for each index containing motif
        for(int i = 0; i < dna.length() - motif.length(); i++){
                rankindex = rankindex + " " + rank;
                rank = dna.indexOf(motif,rank+1);
                
                // Loops continously until rank becomes "-1"
                if(rank < 0){
                    break;
                }
        }
        System.out.println("Results:" + rankindex);
    }
}

package countdnanucleotides;

import java.util.Scanner;

public class CountDNANucleotides {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input DNA Sequence: ");
        String dna = input.next();

        int a = 0;
        int t = 0;
        int c = 0;
        int g = 0;
        
        for(int i=0;i<dna.length();i++){
            char check = dna.charAt(i);
            if(check == 'A'){
                a++;
            }else if(check == 'C'){
                c++;
            }else if(check == 'T'){
                t++;
            }else if(check == 'G'){
                g++;
            }else{
                System.out.println("Error: Encounter Non-Nucleotide");
                System.exit(0);
            }
        }
        System.out.println("Total A: "+a+" Total T: "+t+" Total C: "+c+" Total G: "+g);
        int total = a+t+c+g;
        System.out.println("Total: "+total);
        
        //RNA Translation
        String rna = dna;
        rna = rna.replaceAll("A", "U");
        rna = rna.replaceAll("T", "A");
        rna = rna.replaceAll("G", "X");
        rna = rna.replaceAll("C", "G");
        rna = rna.replaceAll("X", "C");
        
        System.out.println("");
        System.out.println("RNA Translation");
        System.out.println(rna);
    }
    
}

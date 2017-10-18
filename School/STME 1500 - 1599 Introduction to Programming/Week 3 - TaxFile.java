import java.util.Scanner;

public class TaxFile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                
        while(input.hasNextLine()&&input.hasNextInt()){
        int ID = input.nextInt();
        int status = input.nextInt();
        
        if(status < 0 || status > 3){
            System.out.println("Error Status Invalid");
            System.exit(0);
        }
        double income = input.nextDouble();
        
        double a,b,c,d,e,f;
        
        switch (status){
            case 0: //Single Filer
                a = 9275;
                b = 37650;
                c = 91150;
                d = 190150;
                e = 413350;
                f = 415050;
                taxCalc(a,b,c,d,e,f,income,ID);
                break;
            case 1: //Married Filled Jointly or Qualifying Widower
                a = 18550;
                b = 75300;
                c = 151900;
                d = 231450;
                e = 413350;
                f = 466950;
                taxCalc(a,b,c,d,e,f,income,ID);
                break;
            case 2: //Married Filing Separately
                a = 9275;
                b = 37650;
                c = 75950;
                d = 115725;
                e = 206675;
                f = 233475;
                taxCalc(a,b,c,d,e,f,income,ID);
                break;
            case 3: //Head of Household
                a = 13250;
                b = 50400;
                c = 130150;
                d = 210800;
                e = 413350;
                f = 441000;
                taxCalc(a,b,c,d,e,f,income,ID);
                break;
        }
        }
    }
    
    //Method calculating the tax
    public static void taxCalc(double a, double b, double c, double d, double e, double f, double inc, int id){
        double tax = 0;
        int brack = 0;
        if(inc <= a){
            brack = 1;
            tax = inc * 0.1;
        }else if(inc <= b){
            brack = 2;
            tax = a * 0.10 + (inc - a) * 0.15;
        }else if(inc <= c){
            brack = 3;
            tax = a*0.10+ (b-a)*0.15+(inc-b)*0.25;
        }else if(inc <= d){
            brack = 4;
            tax = a*0.10+ (b-a)*0.15+(c-b)*0.25+(inc-c)*0.28;
        }else if(inc <= e){
            brack = 5;
            tax = a*0.10+ (b-a)*0.15+(c-b)*0.25+(d-c)*0.28+(inc-d)*0.33;
        }else if(inc <= f){
            brack = 6;
            tax = a*0.10+ (b-a)*0.15+(c-b)*0.25+(d-c)*0.28+(e-d)*0.33+(inc-e)*0.35;
        }else{
            brack = 7;
            tax = a*0.10+ (b-a)*0.15+(c-b)*0.25+(d-c)*0.28+(e-d)*0.33+(f-e)*0.35+(inc-f)*0.396;
        }
        System.out.println("Client ID: "+id+" Bracket: "+ brack+" Total tax amount: "+(int)(tax*100)/100.0);
    }
}

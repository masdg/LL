import java.io.*;
import java.util.Random; 
import java.util.Scanner;
import java.lang.Math.*;
import java.lang.StringBuilder;
import java.text.DecimalFormat;

public class lab09prime {
    static boolean primeTime = false;//setup bool
    static int cac = 0;//helps with exiting methods
    public static void main(String args[]){
        System.out.println("\n\nInput 'exit' to exit from any function. List of functions:\n1. Smallest number in a set of 3 numbers (smallest)\n2. Check if a number is prime (checkprime)\n3. List a number's prime factors (primefactor)\n4. Repeatedly swap a temperature between Fahrenheit and Celcius (temperature)\n5. Draw a rectangle using characters (rectangle)\n6. Reverse an integer (reverse)\n7. Find all perfect numbers from 1-1000 (perfect)");
        boolean strobe = true;
        long slab = 0; // ______________
        long slab1 = 0;//|general inputs|
        long slab2 = 0;//|______________|
        int err = 0;//decides whether out output certain phrases
        int exit = 0;

        while(strobe){
            if(err == 0){
                System.out.println("To use a function, enter its number or ID which is in parentheses. \nTo exit, type 'exit', and for a list of functions, type 'list'");
                err = 1;
            }

            System.out.print(">");
            Scanner reader = new Scanner(System.in);
            String q = reader.nextLine();
            if(q.toLowerCase().equals("smallest") || q.equals("1")){//smallest/1 executes this
                System.out.println("Enter 3 integers:");
                slab = lab09prime.getLongInput("smallest(#1)", true);
                if (cac==2) {strobe=false; continue;}
                slab1 = lab09prime.getLongInput("smallest(#2)", true);
                if (cac==2) {strobe=false; continue;}
                slab2 = lab09prime.getLongInput("smallest(#3)", true);
                if (cac==2) {strobe=false; continue;}
                System.out.println("The smallest number in the set provided is " + smallest(slab,slab1,slab2));//smallest number in set print
            } else if(q.toLowerCase().equals("checkprime") || q.equals("2")){ //checkprime/2 executes this
                System.out.println("This function tests whether a positive integer is prime. Input:");
                slab = lab09prime.getLongInput("checkprime", false);
                if (cac==2) {strobe=false; continue;}
                if(primeTime(slab)){//check if prime
                    System.out.println("Is prime");//true
                } else{
                    System.out.println("Is not prime");//false
                }
            } else if(q.toLowerCase().equals("primefactor") || q.equals("3")){//primefactor/3 executes this
                System.out.println("This function finds the prime factors of a positive integer. Input:");
                slab = lab09prime.getLongInput("primefactor", false);
                if (cac==2) {strobe=false; continue;}
                primeFactor(slab); //exec primefactorize program
            } else if(q.toLowerCase().equals("temperature") || q.equals("4")) { //temperature/4 executes this
                double slab3 =0;
                System.out.println("Swap repeatedly between Fahrenheit and Celcius.");
                slab3 = lab09prime.getDoubleInput("temperature(Fahrenheit)");
                if (cac==2) {strobe=false; continue;}
                slab1 = lab09prime.getLongInput("temperature(Repititions)", false);
                if (cac==2) {strobe=false; continue;}
                temp(slab3, slab1); //temperature program exec
            } else if(q.toLowerCase().equals("rectangle") || q.equals("5")){ //rectangle method if input is "rectangle" or "5"
                String bbad = "ii";
                System.out.println("Draws a rectangle. Enter a height, width, and character to draw it out of:");
                slab = lab09prime.getLongInput("rectangle(height)", false);
                if (cac==2) {strobe=false; continue;}
                slab1 = lab09prime.getLongInput("rectangle(width)", false);
                if (cac==2) {strobe=false; continue;}
                bbad = lab09prime.getSingleCharInput("rectangle(character)");
                if (cac==2) {strobe=false; continue;}
                rect(slab, slab1, bbad); //print rectangle
            } else if(q.toLowerCase().equals("reverse") || q.equals("6")){ //execute string reversal program
                System.out.println("Enter integer to reverse:");
                DecimalFormat decimalFormat = new DecimalFormat("#");
                Scanner bad = new Scanner(System.in);
                long bab = 0;
                String smorgasborgas = "";
                boolean afaf = false;
                while(!afaf){
                    System.out.print(">");
                    smorgasborgas = bad.nextLine();
                    if(smorgasborgas.toLowerCase().equals("exit")){//exit method
                        afaf = true;
                        lab09prime.cac = 2;
                        continue;
                    }
                    afaf=number(smorgasborgas);
                    if(!afaf){
                        System.out.println("Not an integer");
                        afaf = false; //keep inputing
                    }
                }
                reverse(smorgasborgas); //reverse string + print
            } else if(q.toLowerCase().equals("perfect") || q.equals("7")){ //execute perfect number program
                System.out.println("This program checks if a given input is a perfect number. Input:");
                slab = lab09prime.getLongInput("perfect", false);
                if (cac==2) {strobe=false; continue;}
                perfect(slab);
            } else if(q.toLowerCase().equals("exit")){ //end program
                strobe = false;
            } else if(q.toLowerCase().equals("list")){ //print out list of functions/methods
                System.out.println("1. Smallest number in a set of 3 numbers (smallest)\n2. Check if a number is prime (checkprime)\n3. List a number's prime factors (primefactor)\n4. Repeatedly swap a temperature between Fahrenheit and Celcius (temperature)\n5. Draw a rectangle using characters (rectangle)\n6. Reverse an integer (reverse)\n7. Find all perfect numbers from 1-1000 (perfect)");
            } else {
                System.out.println("1. Smallest number in a set of 3 numbers (smallest)\n2. Check if a number is prime (checkprime)\n3. List a number's prime factors (primefactor)\n4. Repeatedly swap a temperature between Fahrenheit and Celcius (temperature)\n5. Draw a rectangle using characters (rectangle)\n6. Reverse an integer (reverse)\n7. Find all perfect numbers from 1-1000 (perfect)");
            }
        }
    }

    public static long getLongInput(String msg, boolean canNag) {
        long ret = -1;
        Scanner bad = new Scanner(System.in);
        long bab = 0;
        String smorgasborgas = "";
        boolean afaf = false;
        while(!afaf){
            try {
                System.out.print(msg + ">");
                smorgasborgas = bad.nextLine();
                if(smorgasborgas.toLowerCase().equals("exit")){//exit method
                    afaf = true;
                    lab09prime.cac = 2;
                    continue;
                }
                ret = Long.parseLong(smorgasborgas);
                afaf = true;
            } catch (Exception e){
                System.out.println("Not an integer");//catch non integers
                continue;
            }
            if(!canNag && ret < 0){
                System.out.println("No negative integers");//catch negatives
                afaf = false;
            }
        }
        return ret;
     }

    public static double getDoubleInput(String msg) {
        double ret = -1.0;
        Scanner bad = new Scanner(System.in);
        String smorgasborgas = "";
        boolean afaf = false;
        while(!afaf){
            try {
                System.out.print(msg + ">");
                smorgasborgas = bad.nextLine();
                if(smorgasborgas.toLowerCase().equals("exit")){//exit method
                    afaf = true;
                    lab09prime.cac = 2;
                    continue;
                }
                ret = Double.parseDouble(smorgasborgas);
                afaf = true;
            } catch (Exception e){
                System.out.println("Not an integer");//catch non integers
                continue;
            }
        }
        return ret;
    }

    public static String getSingleCharInput(String msg) {
        String ret = "ii";
        Scanner bad = new Scanner(System.in);
        boolean afaf = false;
        while(ret.length()!=1){
            System.out.print(msg + ">");
            ret = bad.nextLine();
            if(ret.toLowerCase().equals("exit")){//exit method
                afaf = true;
                lab09prime.cac = 2;
                continue;
            }
            if(ret.length()!=1){
                System.out.println("Must be a single character"); //rectangle character length warning
            }
        }
        return ret;
    }

    public static long smallest(long a, long b, long c){
        long smol = a; //smol = a
        if (b < smol) smol = b;//if b is smaller then smol = b
        if (c < smol) smol = c;//if c is smaller then smol = c
        return smol;
    }

    public static boolean primeTime(long a) {
        int slorlr = 0;//whether it is equal to 0 decides if number is prime
        if (a <= 3 || a ==5 || a == 7) { //checks for first few primes
            if(a > 1) {
                primeTime = true;
            }else{
                primeTime = false;//not prime if a is 1 or 0
                slorlr++;
            }
        }else{
            if (a%2==0) { //checks if divisible by two
                primeTime = false;//not prime
                slorlr++;
            }else{
                for(long i = 3; i<Math.ceil(a/2); i+=2){//checks if prime
                    if(a%i == 0) {
                        slorlr++;//if not prime add one
                    }
                    if(slorlr!=0) return false;
                }
            }
        }
        primeTime = false;//set default to not prime
        if (slorlr==0){
            primeTime = true;//if found to be prime in method it is true
        }
        return primeTime;//continue/true false
    }

    public static void primeFactor(long a){
        int stored = 0;
        int slorlr = 0;
        if (a <= 1){
            System.out.println("Cannot be factored"); //checks for 1 or 0
            slorlr++;
        }else{
            System.out.print("Prime factors: ");
            if(a%2==0 && a!=2){ //checks if 2 is a factor
                System.out.print("2 ");
                slorlr++;
            }
            for(long i = 3; i<=a;i+=2){ //checks factors for 3+2i where i is any integer
                if(a%i==0){
                    if(primeTime(i)){ //checks if i is prime
                        System.out.print(i + " ");//if it is then it is printed as a prime factor
                        slorlr++;
                    }
                }
            }
            if(slorlr==0){
                System.out.print("None, is prime");
            }
            System.out.println("");
        }
    }

    public static void temp(double a, long r){
        int sweg = 0;
        for(int i = 1; i <= r; i++) {
            a=fahrConvert(a);
            a=celcConvert(a);
        }
    }

    public static double fahrConvert(double a){
        System.out.print(a + " in Fahrenheit is "); //convert fahr to celcius
        a = (a-32)/1.8;
        System.out.println(a + " in Celcius");
        return a;
    }

    public static double celcConvert(double a){
        System.out.print(a + " in Celcius is "); //convert celcius to fahr
        a = 1.8*a+32;
        System.out.println(a + " in Fahrenheit");
        return a;
    }

    public static void rect(long a, long b, String x){
        for(long i = 1; i <=a; i++){ 
            for(long j = 1; j <= b; j++){ //print a row
                System.out.print(x);
            }
            System.out.print("\n"); //move onto next row
        }
    }

    public static void reverse(String stringy){
        String stringer = new StringBuilder(stringy).reverse().toString(); //reverse string
        System.out.println("Reverse: " + stringer); //then print
    }

    public static boolean perfCheck(long i){
        boolean ch = false;
        int snagbag=1; //sum of factors
        for(int j = 2; j <= Math.ceil(i/2); j++) {//perfect number check
            if(i%j==0){
                snagbag+=j; //adds factor to total sum
            }
        }
        if (snagbag == i){
            ch = true;
        }
        return ch;
    }

    public static void perfect(long a){
        int perfcount = 0; //total number of perfect numbers
        boolean d = false;
        System.out.println("Perfect numbers 1-1000 with factors:");
        for(long i = 1; i <=1000; i++){
            if(perfCheck(i)){
                System.out.print(i + ": ");
                for(long c = 1; c <= i/2; c++){
                    if (i%c==0)System.out.print(c + ", ");
                }
                System.out.println(i);
            }
        }
        if(perfCheck(a)) System.out.println("Your input, " + a + ", is a perfect number");
        else System.out.println("Your input, " + a + ", is not a perfect number");
    }

    public static boolean number(String str)
    {
      return str.matches("-?\\d+?");  //match a number with optional '-' and decimal.
    }
}
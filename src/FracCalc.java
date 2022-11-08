import java.util.*;
import java.lang.*;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a fractional equation: ");
        System.out.println(produceAnswer(input.nextLine()));

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        int numerator1;
        int denominator1;
        int numerator2;
        int denominator2;

        Scanner s = new Scanner(input);
        String frac1 = s.next();
        String operator = s.next();
        String frac2 = s.next();

        if (frac1.contains("_")) {
            Scanner whole1 = new Scanner(frac1);
            whole1.useDelimiter("_");
            int wholeFrac1 = whole1.nextInt();
            Scanner fraction1 = new Scanner(whole1.next());
            fraction1.useDelimiter("/");
            numerator1 = fraction1.nextInt();
            denominator1 = fraction1.nextInt();

            numerator1 += (wholeFrac1 * denominator1);
        }
        else {
            Scanner fraction1 = new Scanner(frac1);
            fraction1.useDelimiter("/");
            numerator1 = fraction1.nextInt();
            if (fraction1.hasNextInt()) {denominator1 = fraction1.nextInt();}
            else {denominator1 = 1;}
        }

        if (frac2.contains("_")) {
            Scanner whole2 = new Scanner(frac2);
            whole2.useDelimiter("_");
            int wholeFrac2 = whole2.nextInt();
            Scanner fraction2 = new Scanner(whole2.next());
            fraction2.useDelimiter("/");
            numerator2 = fraction2.nextInt();
            denominator2 = fraction2.nextInt();

            numerator2 += (wholeFrac2 * denominator2);
        }
        else {
            Scanner fraction2 = new Scanner(frac2);
            fraction2.useDelimiter("/");
            numerator2 = fraction2.nextInt();
            if (fraction2.hasNextInt()) {denominator2 = fraction2.nextInt();}
            else {denominator2 = 1;}
        }

        if (operator.equals("+")) {
            int n = (numerator1 * denominator2) + (numerator2 * denominator1);
            int d = (denominator2 * denominator1);
            return "" + (n / d) + "_" + Math.abs((n % d)) + "/" + d;
        }
        if (operator.equals("-")) {
            int n = (numerator1 * denominator2) - (numerator2 * denominator1);
            int d = (denominator2 * denominator1);
            return "" + (n / d) + "_" + Math.abs((n % d)) + "/" + d;
        }




        
        return "";
    }



}

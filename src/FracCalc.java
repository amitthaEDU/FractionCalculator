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
            if (wholeFrac1 < 0) {numerator1 = (wholeFrac1 * denominator1) - numerator1;}
            else {numerator1 += (wholeFrac1 * denominator1);}
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
            if (wholeFrac2 < 0) {numerator2 = (wholeFrac2 * denominator2) - numerator2;}
            else {numerator2 += (wholeFrac2 * denominator2);}
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
            if (n / d == 0) {
                if (n % d == 0) {return "" + 0;}
                else {return "" + nSimple(n % d, Math.abs(d)) + "/" + dSimple(n % d,Math.abs(d));}
            }
            else if (n % d == 0) {return "" + (n / d);}
            return "" + (n / d) + "_" + nSimple(Math.abs((n % d)), Math.abs(d))   + "/" + dSimple(Math.abs((n % d)), Math.abs(d));
        }
        if (operator.equals("-")) {
            int n = (numerator1 * denominator2) - (numerator2 * denominator1);
            int d = (denominator2 * denominator1);
            if (n / d == 0) {
                if (n % d == 0) {return "" + 0;}
                else {return "" + nSimple(n % d, Math.abs(d)) + "/" + dSimple(n % d,Math.abs(d));}
            }
            else if (n % d == 0) {return "" + (n / d);}
            return "" + (n / d) + "_" + nSimple(Math.abs((n % d)), Math.abs(d))   + "/" + dSimple(Math.abs((n % d)), Math.abs(d));
        }
        if (operator.equals("*")) {
            int n = (numerator1 * numerator2);
            int d = (denominator2 * denominator1);
            if (n / d == 0) {
                if (n % d == 0) {return "" + 0;}
                else {return "" + nSimple(n % d, Math.abs(d)) + "/" + dSimple(n % d,Math.abs(d));}
            }
            else if (n % d == 0) {return "" + (n / d);}
            return "" + (n / d) + "_" + nSimple(Math.abs((n % d)), Math.abs(d))   + "/" + dSimple(Math.abs((n % d)), Math.abs(d));
        }
        if (operator.equals("/")) {
            int n = (numerator1 * denominator2);
            int d = (denominator1 * numerator2);
            if (n / d == 0) {
                if (n % d == 0) {return "" + 0;}
                else {return "" + nSimple(n % d, d) + "/" + dSimple(n % d,Math.abs(d));}
            }
            else if (n % d == 0) {return "" + (n / d);}
            return "" + (n / d) + "_" + nSimple(Math.abs((n % d)), Math.abs(d))   + "/" + dSimple(Math.abs((n % d)), Math.abs(d));
        }


        
        return "";
    }
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,(a % b));
    }
    public static int nSimple(int n, int d) {
        n /= gcd(n, d);
        return n;
    }
    public static int dSimple(int n, int d) {
        d /= gcd(n, d);
        return d;
    }


}

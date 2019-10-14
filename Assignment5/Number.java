package A5Question2;

import java.util.Scanner;

public class Number {

    public double count (int n1, int n2) throws ArithmeticException {
        return n1 / n2;
    }

    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 0;
        double quotient = 0;
        Number number = new Number();
        System.out.println("Enter the numerator");
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        System.out.println("Enter the denominator");
        n2 = sc.nextInt();
        try {
            quotient = number.count(n1, n2);
            System.out.println("Quotient is : " + quotient);
        } catch (ArithmeticException ae) {
            System.out.println("Exception !!!! ");
            ae.printStackTrace();
        }
    }
}

package A5Question2;

import java.util.Scanner;

public class NumberTest {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 0;
        int quotient = 0;
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
            System.out.println("Divide by zero exception is thrown");
            ae.printStackTrace();
        }
    }
}

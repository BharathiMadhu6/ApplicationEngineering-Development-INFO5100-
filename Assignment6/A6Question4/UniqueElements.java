package A6Question4;

import java.util.Scanner;

public class UniqueElements {

    public static void main(String[] args) {
        CheckElements checkElements = new CheckElements();
        System.out.println("Enter the number of elements");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
            int[] elements = new int[size];
        System.out.println("Enter the "+size+" elements");
        for (int i = 0; i < size; i++){
            elements[i] = scanner.nextInt();
        }
        boolean result = checkElements.check(elements);
        System.out.println(result);
    }
}

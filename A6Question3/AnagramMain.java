package A6Question3;

import java.util.Scanner;

public class AnagramMain {


    public static void main(String[] args) {

       AnagramTester anagramTester = new AnagramTester();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----ANAGRAM TESTER--------\nEnter the first string");
        String s = scanner.nextLine();
        System.out.println("Enter the second string");
        String t = scanner.nextLine();

       if(s.length() == t.length()) {
            boolean result = anagramTester.isAnagram(s,t);
           System.out.println(result);
       }
       else
           System.out.println("false");
    }
}

package A6Question1;

import java.util.HashMap;
import java.util.Scanner;

public class Machine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // create default users for testing
        HashMap<String, User> userData = new HashMap<>();
        userData.put("A1100", new User("A1100", "Dileep", 30, "seattle", "5853677", "worldtour", 25000));
        userData.put("A1122", new User("A1122", "Suji", 54, "Bangalore", "9620178", "heaven", 30000));
        userData.put("A1133", new User("A1133", "Latha", 30, "Hyderabad", "981212", "rainbow", 12000));
        userData.put("A1144", new User("A1144", "Madhu", 25, "Boston", "5587666", "outandabout", 6000));

        // create atm with default users
        Atm atm = new Atm(100000, 10, userData);

        //main menu
        System.out.println("-------------------------------ATM---------------------------------------");
        System.out.println("-----------------------------WELCOME-------------------------------------");
        int optionSelected = 0;

        while (optionSelected != 3) {
            System.out.println("MENU \n ENTER 1 FOR NEW USER \n ENTER 2 FOR CURRENT USER \n ENTER 3 FOR Exit");
            optionSelected = scanner.nextInt();
            if (optionSelected == 1) {
                atm.createNewUser();
            } else if (optionSelected == 2) {
                atm.currentUserLogin();
            } else  if (optionSelected == 3) {
                System.out.println("Thank You!");
                System.exit(0);
            } else {
                System.out.println("Invalid Option");
            }
        }

    }
}

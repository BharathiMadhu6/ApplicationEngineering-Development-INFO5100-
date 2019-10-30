package A6Question1;

import java.util.*;

class Transaction {
    String transactionType;
    Integer amount;

    Transaction(String transactionType, Integer amount) {
        this.amount = amount;
        this.transactionType = transactionType;
    }
}

public class Atm {

    private int availableAmountInMachine;
    private int transactionFee;
    private Map<String, User> usersData = new HashMap<>();
    private Map<String, ArrayList<Transaction>> recentTransactions = new HashMap<>();

    Atm() {
    }

    Atm(int availableAmountInMachine, int transactionFee, Map<String, User> usersData) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.usersData = usersData;
    }

    public void setUserData(Map<String, User> userData) {
        this.usersData = userData;
    }

    public void createNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new user");
        String randomString = UUID.randomUUID().toString();
        String accNumber = randomString.substring(0, Math.min(randomString.length(), 5));
        User newUser = new User(accNumber, "dontHackMePlease_"+accNumber);

        System.out.println("Account number is : " + newUser.getBankAccountNumber() + " & Password is : " + newUser.getPassword());
        System.out.println("----Enter your details----");
        System.out.println("Enter your Name");
        String name = scanner.nextLine();

        System.out.println("Enter your Address");
        String addr = scanner.nextLine();

        System.out.println("Enter our Phone Number");
        String phone = scanner.nextLine();

        System.out.println("Enter your Age");
        int age = scanner.nextInt();

        System.out.println("Enter the amount you want to start your balance with");
        int amount = scanner.nextInt();

        newUser.setName(name);
        newUser.setPhoneNumber(phone);
        newUser.setAge(age);
        newUser.setAddress(addr);
        newUser.setAvailableBalance(amount);

        this.usersData.put(accNumber, newUser);

        System.out.println("New User Created with Balance: " + amount);

    }

    public void currentUserLogin() {
        Scanner scanner = new Scanner(System.in);
        int subChoice = 0;
        while (subChoice != 5) {
            System.out.println(" ENTER 3 FOR LOGIN \n ENTER 4 FOR FORGOT PASSWORD \n ENTER 5 FOR EXIT");
            subChoice = scanner.nextInt();
            if (subChoice == 3) {
                System.out.println("----- LOGIN PAGE ------ \n");
                System.out.println(" Enter your Bank Account Number ");
                Scanner sc = new Scanner(System.in);
                String accNumber = sc.nextLine();
                User currentUser = this.usersData.get(accNumber);
                if(currentUser == null) {
                    System.out.println("Invalid Account Number");
                    return;
                }
                System.out.println("Enter your password");
                String pwd = sc.nextLine();
                if (pwd.equalsIgnoreCase(currentUser.getPassword())) {
                    System.out.println("Login successful");
                    this.loginMenu(currentUser);
                } else {
                    System.out.println("Login Failed. Please check for password");
                }
            } else if (subChoice == 4) {
                this.forgotPassword();
            }
        }
    }

    private void loginMenu(User currentUser) {
        System.out.println("Choose from the list of operations ");
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 6) {
            System.out.println("1.Available Balance  2.Withdraw  3.Deposit  4.Recent Transactions  5.Change Password  6.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    this.availableBalance(currentUser);
                    break;
                case 2:
                    this.withdraw(currentUser);
                    break;
                case 3:
                    this.deposit(currentUser);
                    break;
                case 4:
                    this.recentTransactions(currentUser);
                    break;
                case 5:
                    this.changePassword(currentUser);
                    break;
                case 6:
                    break;
            }
        }
    }

    private void forgotPassword() {
        System.out.println("Validate your information & reset password.");
        System.out.println("Enter your Account number");
        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.nextLine();
        User currentUser = this.usersData.get(accountNumber);

        if(currentUser == null) {
            System.out.println("No user found with this account number.");
            return;
        }

        System.out.println("Enter your Name");
        String name = sc.nextLine();

        if (!name.equalsIgnoreCase(currentUser.getName())) {
            System.out.println("Invalid Name. Cannot reset password.");
            return;
        }

        System.out.println("Enter your Phone Number");
        String phoneNumber = sc.nextLine();

        if(!phoneNumber.equalsIgnoreCase(currentUser.getPhoneNumber())) {
            System.out.println("Invalid Phone Number. Cannot reset password.");
            return;
        }

        System.out.println("Enter your Age");
        int age = sc.nextInt();
        if(age != currentUser.getAge()) {
            System.out.println("Invalid Age. Cannot reset password.");
            return;
        }

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter your new password.");
        String newPassword = sc2.nextLine();

        currentUser.setPassword(newPassword);
        this.usersData.put(currentUser.getBankAccountNumber(), currentUser);
        System.out.println("Your Password has been reset to " + currentUser.getPassword());
    }

    private void changePassword(User currentUser) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your new password");
        String newPassword = sc.nextLine();
        currentUser.setPassword(newPassword);

        this.usersData.put(currentUser.getBankAccountNumber(), currentUser);
        System.out.println("Your Password has been changed to " + currentUser.getPassword());
    }

    private void deposit(User currentUser) {
        System.out.println("Enter the amount you want to deposit");
        Scanner scanner = new Scanner(System.in);
        int depositAmt = scanner.nextInt();
        int newBalance = currentUser.getAvailableBalance() + depositAmt - transactionFee;
        currentUser.setAvailableBalance(newBalance);
        this.usersData.put(currentUser.getBankAccountNumber(), currentUser);
        recordTransaction(new Transaction("deposit", depositAmt), currentUser);
        availableAmountInMachine += depositAmt + transactionFee;
        System.out.println("Balance in ATM is : " + availableAmountInMachine);
    }

    private void withdraw(User currentUser) {

        Scanner withdrawScanner = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw");
        int withdrawAmount = withdrawScanner.nextInt();

        if (withdrawAmount > currentUser.getAvailableBalance()) {
            System.out.println("Withdraw amount exceeds your available balance. Try entering lesser amount");
            return;
        }

        if ((withdrawAmount + transactionFee) > availableAmountInMachine) {
            System.out.println("ATM has low balance. Withdraw amount higher than ATM balance.");
            return;
        }

        int newBalance = currentUser.getAvailableBalance() - (withdrawAmount + transactionFee);
        currentUser.setAvailableBalance(newBalance);
        this.usersData.put(currentUser.getBankAccountNumber(), currentUser);
        recordTransaction(new Transaction("withDrawal", withdrawAmount), currentUser);
        availableAmountInMachine -= withdrawAmount + transactionFee;
        System.out.println("Balance in ATM is : " + availableAmountInMachine);
    }

    private void availableBalance(User currentUser) {
        System.out.println("Your available balance is : " + currentUser.getAvailableBalance());
    }

    private void recordTransaction(Transaction newTransaction, User currentUser) {
        ArrayList<Transaction> currentUserRecentTransactions = (ArrayList<Transaction>) this.recentTransactions.get(currentUser.getBankAccountNumber());
        if(currentUserRecentTransactions == null || currentUserRecentTransactions.isEmpty()) {
            currentUserRecentTransactions = new ArrayList<>();
        }
        currentUserRecentTransactions.add(newTransaction);
        this.recentTransactions.put(currentUser.getBankAccountNumber(), currentUserRecentTransactions);
    }

    private void recentTransactions(User currentUser) {
        ArrayList<Transaction> currentUserTransactions = this.recentTransactions.get(currentUser.getBankAccountNumber());

        if (currentUserTransactions == null || currentUserTransactions.isEmpty()) {
            System.out.println("No Recent Transactions Yet.");
            return;
        }

        System.out.println("Last 10 Transactions for User " + currentUser.getName() + " with account " + currentUser.getBankAccountNumber());
        int lastIndex = currentUserTransactions.size() - 1;
        int counter = 0;
        for(int i = lastIndex; i >= 0; i--) {
            if (counter > 10) {
                break;
            }
            Transaction transaction = currentUserTransactions.get(i);
            System.out.println(transaction.transactionType + " - " + transaction.amount);
            counter++;
        }
    }
}


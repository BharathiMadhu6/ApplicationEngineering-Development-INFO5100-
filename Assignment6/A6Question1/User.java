package A6Question1;


public class User {

    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;
    private String password;
    private int availableBalance;

    User() {
    }

    User(String bankAccountNumber, String password) {
        this.bankAccountNumber = bankAccountNumber;
        this.password = password;
    }

    User(String bankAccountNumber, String name, int age, String address, String phoneNumber, String password, int availableBalance) {
        this.bankAccountNumber = bankAccountNumber;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.availableBalance = availableBalance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String toString() {
        return " NAME : " + getName() + " , AGE : " + getAge() + " , ADDRESS : " + getAddress() + " ,PHONE_NUMBER : " + getPhoneNumber();
    }

}


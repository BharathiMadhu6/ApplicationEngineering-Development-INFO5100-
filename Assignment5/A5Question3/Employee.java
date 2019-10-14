package A5Question3;

abstract class Employee {

    private String name;
    private int paymentPerHour;

    public Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public abstract int CalculateSalary();

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPaymentPerHour(){
        return this.paymentPerHour;
    }

    public void setPaymentPerHour(int paymentPerHour){
        this.paymentPerHour = paymentPerHour;
    }
}

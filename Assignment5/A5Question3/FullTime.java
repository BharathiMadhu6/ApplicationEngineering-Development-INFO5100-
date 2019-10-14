package A5Question3;

public class FullTime extends Employee{

    private final int fixedWorkingHours = 8;

    FullTime(String name, int paymentPerHour){
        super(name, paymentPerHour);
    }

    public int CalculateSalary() {
        int salary = this.fixedWorkingHours * getPaymentPerHour();
        return salary;
    }
}

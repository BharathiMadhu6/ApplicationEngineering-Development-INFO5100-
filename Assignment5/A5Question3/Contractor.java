package A5Question3;

public class Contractor extends Employee {

    private int workingHours;

    Contractor(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }

    public int CalculateSalary() {
        int salary = getWorkingHours() * getPaymentPerHour();
        return salary;
    }
}

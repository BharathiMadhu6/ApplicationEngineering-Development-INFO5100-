package A5Question3;

public class Tester {

    public static void main(String[] args){
        Contractor contractor = new Contractor("Dileep",100,10);
        FullTime fullTime = new FullTime("Bharathi", 100);
        System.out.println("Salary of contractor "+contractor.getName()+ " is : " +contractor.CalculateSalary());
        System.out.println("Salary of full time employee "+fullTime.getName()+ " is : "+fullTime.CalculateSalary());
    }
}

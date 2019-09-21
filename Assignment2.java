package Assignment2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {

    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */

    public static double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
        System.out.println("SALARY GREATER THAN 5000 METHOD");
        System.out.println("__________________________");

        double sum = 0.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > 5000) {
                sum = sum + employees[i].getSalary();
            }
        }
        System.out.println("The sum of salaries that are greater than 5000 is : " + sum);
        return 0.0;
    }

     /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */

    public static void fizzBuzz(Employee[] employees) {
        // @TODO
        System.out.println("FIZZBUZZ METHOD");

        System.out.println("__________________________");

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() % 3 == 0) {
                System.out.println("Fizz for id " + employees[i].getId());
            } }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() % 5 == 0) {
                System.out.println("Buzz for id " + employees[i].getId());
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() % 5 == 0 && employees[i].getId() % 3 == 0) {
                System.out.println("FizzBuzz for id " + employees[i].getId());
            }
        }
    }

    /*
       This method should calculate tax for an employee in dollars
       If salary of employee is less than or equal to 2500, tax should be 10%
       If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
       If salary of employee is greater than 5000, tax should be 35%
   */
    public static double calculateTax(Employee[] employees) {
        // @TODO
        System.out.println("CALCULATE TAX METHOD");
        System.out.println("__________________________");
        for (int i = 0; i < employees.length; i++) {
            double taxPlusSalary = 0.0;

            if (employees[i].getSalary() <= 2500) {
                taxPlusSalary = employees[i].getSalary() * 0.10;
                System.out.println("The tax for the employee " + employees[i].getFirstName() + " whose salary is : $ " + employees[i].getSalary() + " is : $ " + taxPlusSalary);
            }
        }
        for (int i = 0; i < employees.length; i++) {
            double taxPlusSalary2=0.0;

            if(employees[i].getSalary()>2500 && employees[i].getSalary()<=5000){
                taxPlusSalary2=employees[i].getSalary()*0.25;
                System.out.println("The tax for the employee " + employees[i].getFirstName() + " whose salary is : $ " + employees[i].getSalary() + " is : $ " + taxPlusSalary2);
            }
        }
        for (int i=0;i<employees.length;i++){
            double taxPlusSalary3=0.0;

            if(employees[i].getSalary()>5000){
                taxPlusSalary3=employees[i].getSalary()*0.35;
                System.out.println("The tax for the employee " + employees[i].getFirstName() + " whose salary is : $ " + employees[i].getSalary() + " is : $ " + taxPlusSalary3);
            }
        }
        return 0.0;
    }

    /*
       We are given two employee objects.
       Implement this method to swap salaries of employees */
    public static void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
        System.out.println("\nSWAP SALARIES METHOD");
        System.out.println("__________________________\n");
        int Salary1 = firstEmployee.getSalary();
        int Salary2 = secondEmployee.getSalary();
        System.out.println("Salary of First employee " + firstEmployee.getFirstName() + " is :" + firstEmployee.getSalary());
        System.out.println("Salary of second employee " + secondEmployee.getFirstName() + " is :" + secondEmployee.getSalary());
        firstEmployee.setSalary(Salary2);
        secondEmployee.setSalary(Salary1);
        System.out.println("Salary of First employee " + firstEmployee.getFirstName() + " after the swap is :" + firstEmployee.getSalary());
        System.out.println("Salary of second employee " + secondEmployee.getFirstName() + " after the swap is :" + secondEmployee.getSalary());
    }

    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */

    public static int employeesAgeGreaterThan50(Employee[] employees) {
        System.out.println("\n AGE GREATER THAN 50 METHOD ");
        System.out.println("__________________________\n");
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 50) {
                count += 1;
                System.out.println("Employee " + employees[i].getFirstName() + " age is " + employees[i].getAge());
            }
        }
        System.out.println("the number of employees whose age is greater than 50 are " + count);
        return 0;
    }


    /*
       Implement this method to convert String[] to employees array.
       Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
       This String array of length 2 contains 2 employees in form of string, where
       id = 1
       firstName=John
       age=24
       salary=7500
       convert each string to employee object.
       Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
    */
    public static Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        // iterate employee strings
        // split employee strings to get individual fields
        // create employee objects
        // add to employees array field
        System.out.println("\nString to Employee object conversion \n");
        for(int i = 0; i < employeesStr.length; i++) {
            String singleEmployeeStr = employeesStr[i];
            String[] employeesValues = singleEmployeeStr.split(",");
            int id = Integer.parseInt(employeesValues[0]);
            String firstName = employeesValues[1];
            int age = Integer.parseInt(employeesValues[2]);
            int salary = Integer.parseInt(employeesValues[3]);
            Employee employee = new Employee(id, firstName, age, salary);
            employees[i] = employee;
            System.out.println(employees[i].getId()+ " " +employees[i].getFirstName()+" "+employees[i].getAge()+" "+employees[i].getSalary());
        }
        return employees;
    }
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John" */

    public static void reverseFirstName(Employee employee) {
        // @TODO

        String name = employee.getFirstName();
        String revname = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            revname = revname + name.charAt(i);
        }
        System.out.println("the first name is "+employee.getFirstName());
        System.out.println("the reversed name is " + revname);
    }

    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit */
    public static void isContainDigit(Employee employee) {
        // @TODO

        if (employee.getFirstName().matches("(.)*(\\d)(.)*")) {
            System.out.println("True, the employees first name contains one or more digits");
        } else
            System.out.println("False, the employees first name does not contain any number");
    }

    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public static void tripleSalary(Employee employee) {

        double salary = employee.getSalary();
        raiseSalary(3, salary);
        // @TODO
    }

    public  static void raiseSalary(double byTimes, double salary) {

        double raisedSalary = byTimes * salary;
        System.out.println("The trippled salary of employee whose original salary was : " + salary + " is " + raisedSalary);
    }



    public static void main(String[] args) {

        Employee[] employee = new Employee[6];
        employee[0] = new Employee(15, "Jhon6", 56, 4000);
        employee[1] = new Employee(2, "Bharathi", 27, 1000);
        employee[2] = new Employee(3, "Latha", 29, 10000);
        employee[3] = new Employee(10, "Suji", 52, 11000);
        employee[4] = new Employee(5, "Madhu", 55, 2500);
        employee[5] = new Employee(6, "Dileep1", 29, 3000);

        String[] employeesStr=new String[]{"1,Jhon,26,4000","2,Bharathi,27,10000","3,Suji,52,11000","4,Latha,29,10000","5,Madhu,55,13000","6,Dileep,29,3000"};
        System.out.println("Employee List");
        System.out.println("ID    NAME    AGE  SALARY");
        System.out.println("__________________________");
        for (int i=0; i < employee.length; i++)
        {
            System.out.println(employee[i].getId()+"__ "+employee[i].getFirstName()+" __"+employee[i].getAge()+" __"+employee[i].getSalary());
        }

        //Method Calls begin

         salaryGreaterThanFiveThousand(employee);
         fizzBuzz(employee);
         calculateTax(employee);
         employeesAgeGreaterThan50(employee);
         swap(employee[0],employee[4]);

        System.out.println("\nTO CHECK IF NAME CONTAINS NUMBER METHOD ");
        System.out.println("__________________________\n");
        for (int i=0;i<employee.length;i++)
        {
            isContainDigit(employee[i]);
        }

        System.out.println("\nREVERSE FIRST NAME METHOD");
        System.out.println("__________________________\n");
        for (int i=0;i<employee.length;i++)
        {
            reverseFirstName(employee[i]);
        }

        System.out.println("\nTO TRIPLE THE SALARY METHOD");
        System.out.println("__________________________\n");
        for (int i=0;i<employee.length;i++)
        {
            tripleSalary(employee[i]);
        }


        createEmployees(employeesStr);
    }

}





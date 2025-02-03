package day2LabAssignment.employeePaySystem;

public class SalariedEmployee extends Employee implements SalaryPayment {

    public static float percentageIncrement = 0;
    public SalariedEmployee(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }
    public static void setIncrement(float incrementPercentage){

        percentageIncrement=incrementPercentage;
    }
    public void setIncreasedSalary(){

        super.salary += super.salary*percentageIncrement;
    }
    public double getWeeklySalary(){

        return (this.salary)*7;
    }
}

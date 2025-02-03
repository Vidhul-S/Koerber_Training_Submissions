package day2LabAssignment.employeePaySystem;

public class ContractEmployee extends Employee implements SalaryPayment{

    public static float percentageIncrement = 0;
    public float percentagePaid;
    public int weeklySales;
    public ContractEmployee(int id, String firstName, String lastName, float percentagePaid, int weeklySales) {

        super(id, firstName, lastName, 0);
        this.percentagePaid = percentagePaid;
        this.weeklySales = weeklySales;
        setSalary(percentagePaid * weeklySales / (100 * 7));
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

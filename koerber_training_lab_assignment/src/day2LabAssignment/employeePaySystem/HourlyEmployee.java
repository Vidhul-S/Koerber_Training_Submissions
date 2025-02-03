package day2LabAssignment.employeePaySystem;

public class HourlyEmployee extends Employee implements SalaryPayment{

    public static float percentageIncrement = 0;
    public float hoursPerWeek,hourlyRate;
    public HourlyEmployee(int id, String firstName, String lastName, float hourlyRate, float hoursPerWeek) {

        super(id, firstName, lastName, 0);
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;
        setSalary(hourlyRate * hoursPerWeek / 7);
    }
    public static void setIncrement(float incrementPercentage){

        percentageIncrement=incrementPercentage;
    }
    public void setIncreasedSalary(){

        super.salary += super.salary*percentageIncrement;
    }
    public double getWeeklySalary() {

        return (this.salary) * 7;
    }
}

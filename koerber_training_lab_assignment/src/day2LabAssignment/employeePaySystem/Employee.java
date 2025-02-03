package day2LabAssignment.employeePaySystem;

public class Employee implements Payable{

    public int id;
    public String firstName;
    public String lastName;
    public double salary;
    public Employee(int id, String firstName, String lastName, double salary){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public int getID(){

        return this.id;
    }
    public String getFirstName(){

        return new String(this.firstName);
    }
    public String getLastName(){

        return new String(this.lastName);
    }
    public double getSalary(){

        return this.salary;
    }
    public void setSalary(double salary){

        this.salary=salary;
    }
    public double getAnnualSalary(){

        return (this.salary)*365;
    }
    public double raiseSalary(int percent){
        this.salary += this.salary*percent/100;
        return this.salary;
    }
    @Override
    public String toString(){
        return "Employee[id="+this.id+",name="+this.firstName+this.lastName+",salary="+this.salary;
    }
    public void getPayment() {

        System.out.println("Employee Payment Info:");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Salary: " + this.salary);
        System.out.println("Total Payment: " + this.salary);
    }
}

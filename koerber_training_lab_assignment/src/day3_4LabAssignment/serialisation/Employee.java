package day3_4LabAssignment.serialisation;

import day3_4LabAssignment.serialisation.Address;

import java.io.Serializable;

public class Employee implements Serializable {

    public Employee(){}
    private int id;
    private String firstName;
    private Address address;
    private transient double salary;

    public Employee(int id, String firstName, Address address, double salary){

        this.id = id;
        this.firstName = firstName;
        this.address = address;
        this.salary = salary;
    }
    public int getID(){

        return this.id;
    }
    public String getFirstName(){

        return this.firstName;
    }
    public Address getAddress(){

        return this.address;
    }
    public double getSalary(){

        return this.salary;
    }
    public void setSalary(double salary){

        this.salary=salary;
    }
    @Override
    public String toString(){
        return "Employee[id="+this.id+",name="+this.firstName+"Address"+this.address +",salary="+this.salary;
    }
}

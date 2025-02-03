package day9LabAssignment.java10_17;

public class E_Records {
    public static void main(String[] args) {
        E_Person person = new E_Person("John Doe", "john.doe@example.com", 50000.0);

        System.out.println("Name: " + person.name());
        System.out.println("Email: " + person.email());
        System.out.println("Salary: " + person.salary());

        System.out.println("Net Salary: " + person.getNetSalary());

    }
}

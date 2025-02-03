package day9LabAssignment.java10_17;

//DTO: lombok small framewrok to autogen getter...

//public record Person{
//    private static String name;
//    private static String email;
//    private static double salary;
//
//    public Person(String name, String email, double salary) {
//        this.name = name;
//        this.email = email;
//        this.salary = salary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Double.compare(person.salary, salary) == 0 && name.equals(person.name) && email.equals(person.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, email, salary);
//    }
//}

public record E_Person(String name, String email, double salary) implements Employable {

    @Override
    public double getNetSalary() {
        return salary * 0.85;
    }
}

//1. immutable without boilerplate code
//2. aka final class  can not be absttract
//3. can imp new interface


















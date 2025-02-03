package day3_4LabAssignment.serialisation;

import java.io.*;

public class employeeSerialisation extends Employee {
    public static void main(String[] args){
        Address a1 = new Address("some place");
        Employee e1 = new Employee(123,"Ravi",a1,30000.00);

        try(ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("saveFile.txt")));
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("saveFile.txt")));){
            oo.writeObject(e1);
            System.out.println("Employee object serialised"+e1);

            Employee e2 = (Employee) oi.readObject();
            System.out.println("Employee object after serailisation"+e2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

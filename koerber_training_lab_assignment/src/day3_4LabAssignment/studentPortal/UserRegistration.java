package day3_4LabAssignment.studentPortal;

import java.util.Scanner;

public class UserRegistration {

    public Student registration()throws InvalidCountryException{

        Scanner s = new Scanner(System.in);
        System.out.println("Enter name ");
        String name = s.nextLine();
        System.out.println("Enter roll number ");
        int rollnum = s.nextInt();
        s.nextLine();
        System.out.println("Enter country name");
        String country = s.nextLine();
        if(!("India".equalsIgnoreCase(country))){

            throw new InvalidCountryException("InvalidCountryException");
        }
        Student st = new Student(name,country,rollnum);
        System.out.println("User registration done successfully");
        return st;
    }
    public static void main(String[] args) {

        UserRegistration userRegistration = new UserRegistration();

        try {

            Student registeredStudent = userRegistration.registration();
            System.out.println("Registered Student Details: " + registeredStudent);
        }
        catch (InvalidCountryException e) {

            System.out.println("Registration failed: " + e.getMessage());
        }
    }
}

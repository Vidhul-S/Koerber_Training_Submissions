package day3_4LabAssignment.studentPortal;

public class Student {
    private String name,country;
    private int rollNum;
    public Student(String name,String country,int rollNum){

        this.name = name;
        this.country = country;
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getRollNum() {
        return rollNum;
    }

    @Override
    public String toString() {

        return new StringBuilder().append("Name = ").append(name).append(", Country = " ).append(country).append(", Roll no. = ").append(rollNum).toString();
    }
}

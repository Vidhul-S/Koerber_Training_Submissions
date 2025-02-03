package day3_4LabAssignment.ageException;

import java.util.Arrays;

public class NameAndAge{
    private void ageCheck(String age) throws InvalidAgeException,ClassCastException{

        int a = Integer.parseInt(age.trim());
        if(!(a>17 && a<61)){

            throw new InvalidAgeException("Age not valid");
        }
    }
    public static void main(String [] args) {

        NameAndAge n = new NameAndAge();
        try {
            n.ageCheck(args[1]);
        }
        catch (InvalidAgeException e){

                System.out.println("Please enter age of range 18-60\n"+e);
        }
        catch (Exception e){
            System.out.println("Enter name after a space then age during class call");
        }
    }
}

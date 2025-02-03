package day3_4LabAssignment.arthematic;

import java.util.Scanner;

public class Divider {
    private void run(int d,int n)throws DivideByZeroException{
        if(n == 0){
            throw new DivideByZeroException(" caught ");
        }
        else {
            System.out.println(new StringBuilder().append("The quotient of ").append(d).append("/").append(n).append(" = ").append(d/n).toString());
        }
    }
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter 2 integer numbers ");
        int d = s.nextInt();
        int n = s.nextInt();
        Divider div = new Divider();
        try{

            div.run(d,n);
        }
        catch (Exception e){
            System.out.print(e.toString());
        }
        finally {
            System.out.print("Inside finally block");
        }
    }
}

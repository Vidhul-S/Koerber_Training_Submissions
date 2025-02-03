package day1LabAssignment;

import java.util.Scanner;

public class Fib {
    public static int a=0,b=0,n=0,nc=0;
    public float sum=0;
    public static int copyOfN(int n){
        return n;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Fib f = new Fib();
        System.out.println("Enter the number of Terms to be computed of the series");
        n=s.nextInt();
        nc=copyOfN(n);
        f.comp(n,a,b);
    }
    public int comp (int n,int a , int b ){
        if(b==0) {
            b++;
        }
        if(n==0) {
            System.out .println("Avg = "+sum/nc);
            return b;
        }
        else{
            System.out.println(b);
            sum+=b;
            return comp(--n,b,b+a);
        }
    }
}

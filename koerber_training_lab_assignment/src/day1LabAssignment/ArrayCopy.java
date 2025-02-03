package day1LabAssignment;

import java.util.Scanner;

public class ArrayCopy {
    public static int[] copyOf(int[] a){
        int[] copy = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        return copy;
    }
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int sz = s.nextInt();
        int[] a = new int[sz];
        System.out.println("Enter an array one by one with enter and enter any non numeric character to end");
        for (int i = 0; i < sz; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            a[i] = s.nextInt();
        }
        int [] copyOfA = copyOf(a);
        System.out.println("Array copied");
    }
}


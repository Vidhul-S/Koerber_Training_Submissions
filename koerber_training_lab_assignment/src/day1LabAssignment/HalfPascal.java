package day1LabAssignment;

import java.util.Scanner;

public class HalfPascal {
    public static void pascalTriangleGen(int n,int [][] pas){
        for(int i=0;i<n;i++){

            for(int j=0;j<i;j++){

                if(i==0 || j==0){

                    pas[i][j]=1;
                }
                else{

                    pas[i][j]=pas[i-1][j-1]+pas[i-1][j];
                }
            }
        }

    }
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of rows to be present in the triangle");
        int n = s.nextInt();
        int [][] pas= new int[n][n];
        pascalTriangleGen(n,pas);
        System.out.println("The Triangle");
        for(int i=0;i<n;i++) {

            for (int j = 0; j < i; j++) {

                System.out.print(pas[i][j]);
            }
            System.out.println();
        }
    }
}

package day1LabAssignment;

import java.util.Scanner;

public class GradeAverage {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the number of students: ");
            int n = s.nextInt();
            int[] grades = new int[n];

            for (int i = 0; i < n; i++) {
                int g = -1;

                while (g < 0 || g > 100) {
                    System.out.print("Enter the grade for student " + (i + 1) + ": ");
                    g = s.nextInt();

                    if (g < 0 || g > 100) {
                        System.out.println("Invalid grade, try again...");
                    }
                }

                grades[i] = g;
            }

            double t = 0;

            for (int g : grades) {
                t += g;
            }

            double average = t / n;
            System.out.println("The average is: " + average);
        }
}
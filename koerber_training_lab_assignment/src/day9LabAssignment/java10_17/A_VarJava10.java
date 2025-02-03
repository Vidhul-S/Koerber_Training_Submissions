package day9LabAssignment.java10_17;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class A_VarJava10 {
    public static void main(String[] args) {

        var number = 42;  // Inferred as 'int'

        var message = "Hello, Java 10!";  // Inferred as 'String'

        var list = new ArrayList<String>();  // Inferred as 'ArrayList<String>'

        var add = (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b;// Inferred as 'BiFunction<Integer, Integer, Integer>'

        System.out.println("Number: " + number);
        System.out.println("Message: " + message);
        System.out.println("List: " + list);
        System.out.println("Add Result: " + add.apply(3, 5));
    }
}

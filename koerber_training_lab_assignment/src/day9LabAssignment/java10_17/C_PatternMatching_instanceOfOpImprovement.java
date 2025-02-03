package day9LabAssignment.java10_17;

public class C_PatternMatching_instanceOfOpImprovement {
    public static void main(String[] args) {
        Object obj = "Hello, Pattern Matching!";
        if (obj instanceof String str) {
            System.out.println("String length: " + str.length());
        } else {
            System.out.println("Not a string.");
        }

        // Without Pattern Matching (older approach)
//        if (obj instanceof String) {
//            String str = (String) obj; // Explicit casting
//            System.out.println("String length: " + str.length());
//        }
    }
}

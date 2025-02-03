package subClasses;

public class Div {
    public static int div (int a, int b) {
        if(b!=0){
            return (int) a/b;
        }
        else throw new ArithmeticException("Divide by zero");
    }
    public static void someInternalMethod(){
        System.out.println("Internal Method");
    }
}

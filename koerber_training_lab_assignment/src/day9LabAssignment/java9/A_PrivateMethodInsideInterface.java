package day9LabAssignment.java9;
//private method inside an interface
//interface Foof{
//}
 interface Java8DBLogging
{
    private void aPrivateMethod(){
        System.out.println("A private method can't be accessed from outside");
    }
    default void logInfo(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log Info Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

    default void logWarn(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log warn Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

    default void logError(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log error Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

}

public class A_PrivateMethodInsideInterface implements Java8DBLogging{
    public static void main(String[] args) {

    }
}

















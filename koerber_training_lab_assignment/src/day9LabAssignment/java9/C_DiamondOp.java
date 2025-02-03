package day9LabAssignment.java9;
import day9LabAssignment.pojo.Book;

class A <T>{
    T value;
    public A(){}
    public A (T value) {
        this.value = value;
    }
        void foo(){

        System.out.println(value);
        }
}
class B extends  A<Book>{
    public B (){}
    public B (Book value) {
        super(value);
    }
    void foo(){
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp {
    public static void main(String[] args) {
        B book = new B("Java 9");
    }
}

package day9LabAssignment.java10_17;

//https://rollbar.com/blog/what-are-sealed-classes-in-java/
 /*
 In Java, sealed classes are a feature introduced in Java 15 (as a preview feature)
 and became stable in Java 17. They allow the class to define a restricted set of subclasses,
 which enhances control over class hierarchies and improves security by limiting the
 inheritance of certain classes.
 */


sealed class  Animal permits Dog, Cat{
    void sound(){
        System.out.println();
    }
}
non-sealed class Dog extends Animal{

}
final class Cat extends Animal{

}
class Human{

}
public class E_SealedClasses {
    public static void main(String[] args) {

    }
}

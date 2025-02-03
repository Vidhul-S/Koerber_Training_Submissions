package day7LabAssignment.singleton;

import java.io.Serializable;

public class MySingleton implements Cloneable, Serializable{

//    public static MySingleton getInstance() {  // this is a classical implementation
//        return instance;                       // of singleton which has various issues
//    }                                          // and should be avoided.
//private static MySingleton instance;
//static {
//    try {
//        instance = new MySingleton();
//    } catch (Exception e) {
//        throw new RuntimeException("Exception occurred in creating singleton instance");
//    }
//}

    private static  MySingleton instance = new MySingleton();

    private MySingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static synchronized MySingleton getInstance() {
        if(instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed");
    }
    protected Object readResolve() {
        return instance;
    }
    /*
    This implementation is the most robust considering all the possible
    operation on a singleton without using a enum singleton but can be
    better just by writing an enum singleton
     */
}

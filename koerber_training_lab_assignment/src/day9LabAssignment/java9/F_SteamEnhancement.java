package day9LabAssignment.java9;
import  java.util.*;
import java.util.stream.Stream;

public class F_SteamEnhancement {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 6, 8, 9, 50);
        list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
        //takewhile
        list.stream().takeWhile(n -> n % 2 == 0).forEach(n -> System.out.println(n));

//	dropwhile
        list.stream().dropWhile(n -> n % 2 == 0).forEach(n -> System.out.println(n));
    }
}

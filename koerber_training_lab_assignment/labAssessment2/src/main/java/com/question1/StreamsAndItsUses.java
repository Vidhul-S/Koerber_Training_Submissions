package com.question1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StreamsAndItsUses {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);
        System.out.println("------printing map------");
        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry
                        .getKey() + " -> " + entry.getValue()));
        System.out.println("-----printing records where the key contains 'raj'-------");
        map.entrySet().stream()
                .filter(entry -> entry.getKey().contains("raj"))
                .forEach(entry -> System.out.println(entry
                        .getKey() + " -> " + entry.getValue()));
        System.out.println("------map sorted by key------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry
                        .getKey() + " -> " + entry.getValue()));
        System.out.println("------map sorted by values------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry
                        .getKey() + " -> " + entry.getValue()));
        System.out.println("------map reverse sorted by key------");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));


        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(new Student(109, "raj", 95), 95);
        studentMap.put(new Student(61, "keta", 78), 78);
        studentMap.put(new Student(11, "gunika", 98), 98);
        studentMap.put(new Student(19, "keshav", 97), 97);

        System.out.println("------records sorted by student name------");
        studentMap.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry
                        .getKey().getName()))
                .forEach(entry -> System.out.println(entry
                        .getKey() + " -> " + entry.getValue()));
        System.out.println("------records sorted by student id------");
        studentMap.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry
                        .getKey().getId()))
                .forEach(entry -> System.out.println(entry
                        .getKey() + " -> " + entry.getValue()));
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private int id;
    private String name;
    private int marks;
}
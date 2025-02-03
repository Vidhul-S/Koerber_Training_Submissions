package day9LabAssignment.java9;

import java.util.List;
import java.util.stream.Stream;

public class J_StreamAPIEnhancements {
    public static void main(String[] args) {
        String value = null;

        // The Stream.ofNullable() method creates
        // a single-element stream if the given value
        // is non-null, or an empty stream if the value is null.
        Stream<String> stream = Stream.ofNullable(value);
        System.out.println(stream.count());
        //This overloaded version of iterate allows you to define
        // a termination condition for the infinite stream generated.
        Stream.iterate(1, n -> n <= 10, n -> n + 1)
                .forEach(System.out::println);

        List<String> items = List.of("A", null, "B", null, "C");

        // Handle nulls using Stream.ofNullable
        items.stream()
                .flatMap(Stream::ofNullable)
                .forEach(System.out::println);
    }
}

package dsa_ground.streams;

//Filter students who scored >= 50.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStudents {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 70),
            new Student("Bob", 45),
            new Student("Charlie", 85),
            new Student("David", 55),
            new Student("Eve", 40)
        );

        List<String> sa = students.stream().filter(j -> j.marks >=50)
            .map(s -> s.name)
            .collect(Collectors.toList());
        System.out.println(sa);
    }

}

class Student {
     String name;
     int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

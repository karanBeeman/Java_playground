package java_ground.collection_framework;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetInterfaceLearning {

    public static void main(String[] args) {
        // Set is a collection that does not allow duplicate elements and does not maintain any specific order.
        // It is implemented by HashSet, LinkedHashSet, and TreeSet classes.

//        0   1  2  3
//        [] [] [] []

        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1, "karan")); // memory address
        set.add(new Student(1, "karan")); // memory address

        Set<String> stringSet = new HashSet<>();
        stringSet.add("karan");
        stringSet.add("karan");

        for (String student : stringSet) {
            System.out.println("stringSet " + student);
        }

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(1);

        for (int intValue : integerSet) {
            System.out.println(intValue);
        }

        for (Student student : set) {
            System.out.println(student.id + " " + student.name);
        }

        Set<TreeSetLearning> treeSet = new TreeSet<>();
        treeSet.add(new TreeSetLearning(1, "java"));
        treeSet.add(new TreeSetLearning(3, "java"));
        treeSet.add(new TreeSetLearning(2, "java"));
        for (TreeSetLearning treeSetLearning : treeSet) {
            System.out.println(treeSetLearning.id + " " + treeSetLearning.name);
        }

//        TreeSet<Student> set1 = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.id - s2.id; // sort by id
//            }
//        }); this is the old way of creating comparator using anonymous inner class, now we can use lambda expression to create comparator in a more concise way

        Set<ComparatorTreeSetLearning> comparatorTreeSet = new TreeSet<>(Comparator.comparing(o -> o.id)); // sort by id using method reference
        comparatorTreeSet.add(new ComparatorTreeSetLearning("2", "java"));
        comparatorTreeSet.add(new ComparatorTreeSetLearning("1", "java"));

        for (ComparatorTreeSetLearning comparatorTreeSetLearning : comparatorTreeSet) {
            System.out.println(comparatorTreeSetLearning.id + " " + comparatorTreeSetLearning.name);
        }
    }

}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class TreeSetLearning implements Comparable<TreeSetLearning> {
    // TreeSet is a sorted set that does not allow duplicate elements and maintains the natural ordering of its elements.
    // It is implemented by the TreeSet class, which uses a Red-Black tree data structure to store its elements.
    // TreeSet does not allow null elements and will throw NullPointerException if you try to add null.

    String name;
    int id;

    public TreeSetLearning(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(TreeSetLearning o) {
        return Integer.compare(this.id, o.id);
    }
//    If compareTo < 0 → go left
//    If compareTo > 0 → go right
//    If compareTo == 0 → duplicate, don’t insert
}

class ComparatorTreeSetLearning {
    // If we want to sort TreeSet based on name instead of id, we can create a Comparator and pass it to the TreeSet constructor.

    String name;
    String id;

        public ComparatorTreeSetLearning(String id, String name) {
            this.name = name;
            this.id = id;
        }

}
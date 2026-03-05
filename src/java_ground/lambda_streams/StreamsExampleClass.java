package java_ground.lambda_streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExampleClass {

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("BOB", 80), new Student("ALICE", 90), new Student("CHARLIE", 70)); // immutable list of students

        List<Employee> employees = List.of(
            new Employee("Alice", "IT"),
            new Employee("Bob", "HR"),
            new Employee("Charlie", "IT")
        );

        students.stream().filter(s -> s.marks > 70).map(Student::getName).forEach(System.out::println);
        Map<String, Optional<Student>> ss =  students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.maxBy(Comparator.comparing(Student::getMarks))));
        System.out.println(ss);


        Map<String, List<String>> employe = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(employe);

        List<Integer> arr = List.of(1,2,3,4,5,6,6); // immutable list - cannot be modified after creation
//        what will happen if we try to modify the list? - UnsupportedOperationException will be thrown at runtime if we try to modify the list (e.g., arr.add(7);)
//        what if i want to remove an element from the list? - UnsupportedOperationException will be thrown at runtime if we try to remove an element from the list (e.g., arr.remove(0);)
//        what if i want to filter the list? - We can use streams to filter the list without modifying the original list (e.g., arr.stream().filter(x -> x > 3).toList();)
        Predicate<Integer> isEven = x -> x % 2 == 0;  // we can also define the lambda expression as a Predicate functional interface and then pass it to the filter method
        arr.stream().filter(isEven).forEach(System.out::println); // here we are passing behavior (lambda expression) to the filter method to filter out even numbers from the list and then we are using forEach to print the filtered numbers. The original list remains unchanged.
       // what is the difference here compare to the traditional way of filtering the list using a loop? - In the traditional way, we would have to create a new list to store the filtered numbers and then we would have to loop through the original list and add the filtered numbers to the new list. This is more verbose and less efficient than using streams, which allows us to filter the list in a more concise and efficient way without creating an intermediate list.

        arr.stream().filter((x) -> x % 2 == 0).forEach(System.out::println); // here we are directly passing the lambda expression to the filter method without defining it as a Predicate functional interface. This is a more concise way of writing the same code as above. The behavior is the same, it will filter out even numbers from the list and print them, while keeping the original list unchanged.
      //   x -> x % 2 == 0 - explain this lambda expression - it is a shorthand way of writing an anonymous function that takes an integer x as input and returns true if x is even (i.e., x % 2 == 0) and false otherwise. This lambda expression is passed as an argument to the filter method, which uses it to filter the elements of the stream based on the condition defined in the lambda expression. In this case, it will filter out all the even numbers from the list.

        // sum of aggregates
        arr.stream().filter(s -> s % 2 == 0).map(n -> n * n).forEach(System.out::println);

        // distinct
        List<Integer> list = List.of(1,8,6,2,5,4,8,3,7,3,7,6);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);

        // sorted
       list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

        // sorted with custom comparator
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);

        // find first
        list.stream().findFirst().ifPresent(System.out::println);

        // find any
        list.stream().findAny().ifPresent(System.out::println);

        // count
        long count = list.stream().filter(s -> s % 2 == 0).count();

        // all match
        boolean allEven = list.stream().allMatch(s -> s % 2 == 0);

        // any match
        boolean anyEven = list.stream().anyMatch(s -> s % 2 == 0);

        // none match
        boolean noneEven = list.stream().noneMatch(s -> s % 2 == 0);

        // reduce
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        // here we are using the reduce method to sum all the elements of the list. The first argument is the identity value (0 in this case) and the second argument is a lambda expression that takes two integers a and b and returns their sum. The reduce method will apply this lambda expression cumulatively to the elements of the stream, starting with the identity value, and return the final result (the sum of all elements in the list).
         System.out.println(sum);

         // collect
            List<Integer> evenNumbers = list.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
         // here we are using the collect method to collect the filtered even numbers into a new list. The filter method is used to filter out the even numbers from the stream, and then the collectmethod is used to collect those filtered numbers into a new list using Collectors.toList().

        // flatMap
            List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
            List<Integer> flatList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
            // here we are using the flatMap method to flatten a list of lists into a single list. The flatMap method takes a function that maps each element of the stream to a new stream (in this case, we are using List::stream to convert each inner list into a stream) and then flattens those streams into a single stream. Finally, we collect the flattened stream into a new list using Collectors.toList().
            System.out.println(flatList);

         // partitioningBy
            Map<Boolean, List<Integer>> partitioned = list.stream().collect(Collectors.partitioningBy(s -> s % 2 == 0));
            // here we are using the partitioningBy collector to partition the elements of the stream into two groups based on a predicate (in this case, whether the number is even or not). The result is a map where the key is a boolean value (true for even numbers and false for odd numbers) and the value is a list of integers that belong to that group.
            System.out.println(partitioned);

         // groupingBy
            Map<Integer, List<Integer>> grouped = list.stream().collect(Collectors.groupingBy(s -> s % 3));
            // here we are using the groupingBy collector to group the elements of the stream based on a classifier function (in this case, the remainder when divided by 3). The result is a map where the key is the result of the classifier function (0, 1, or 2) and the value is a list of integers that belong to that group.
            System.out.println(grouped);

    }

}

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

     public String getName() {
         return name;
     }

     public int getMarks() {
         return marks;
     }
}

class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }
}
package java_ground.lambda_streams;

public class BuildInFunctionalInterface {

    public static void main(String[] args) {
        FunctionalInterfaceExample example = new FunctionalInterfaceExample();
        example.methodWithFunctionalInterface();
        CustomFunctionalInterfaceExample customExample = new CustomFunctionalInterfaceExample();
        customExample.methodWithCustomFunctionalInterface();
    }

}

class FunctionalInterfaceExample {

    // what is a functional interface? - A functional interface is an interface that has exactly one abstract method.
    // It can have multiple default or static methods, but it must have only one abstract method.
    // Functional interfaces are used as the basis for lambda expressions and method references in Java.

//    Purpose: Takes an input of type T and returns a result of type R.
//    Single abstract method: R apply(T t)
//    Use case: Transform or map data.

      public void methodWithFunctionalInterface() {
        // Using a built-in functional interface: Runnable
        Runnable runnable = () -> System.out.println("This is a Runnable functional interface example.");
        runnable.run();

        // Using another built-in functional interface: Function
          // here Integer is input and another Integer is output
        java.util.function.Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println("Square of 5: " + squareFunction.apply(5)); // Output: Square of 5: 25
    }
}

class CustomFunctionalInterfaceExample {

    // how functional interface differ from normal interface? - A normal interface can have multiple abstract methods,
    // while a functional interface can have only one abstract method.
    // This is what allows functional interfaces to be used with lambda expressions and method references, as they can be implemented with a single block of code.
    // In contrast, a normal interface would require a separate implementation for each abstract method, making it less concise and less suitable for use with lambda expressions.

    // still a functional interface abstract method requires an implementation, but we can use lambda expressions to provide that implementation in a more concise way compared to traditional anonymous classes.


    @FunctionalInterface
    interface MyFunctionalInterface {
        int execute(int x);
    }

    public void methodWithCustomFunctionalInterface() {
        MyFunctionalInterface myFunc = (x) -> x * x; // Lambda expression that implements the execute method
        myFunc.execute(5); // Output: 25
    }
}

class PredicateExample {
    // Purpose: Takes an input of type T and returns a boolean result.
    // Single abstract method: boolean test(T t)
    // Use case: Used for filtering or matching conditions.

     public void methodWithPredicate() {
        java.util.function.Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // Output: Is 4 even? true
        System.out.println("Is 5 even? " + isEven.test(5)); // Output: Is 5 even? false

    }
}

class CustomPredicateExample {
    @FunctionalInterface
    interface MyPredicate {
        boolean test(int x);
    }

     public void methodWithCustomPredicate() {
        MyPredicate isEven = x -> x % 2 == 0; // Lambda expression that implements the test method
        System.out.println("Is 4 even? " + isEven.test(4)); // Output: Is 4 even? true
        System.out.println("Is 5 even? " + isEven.test(5)); // Output: Is 5 even? false
    }
}

class ConsumerExample {
    // Purpose: Takes an input of type T and performs an action without returning a result.
    // Single abstract method: void accept(T t)
    // Use case: Used for performing operations on data, such as printing or modifying objects.

     public void methodWithConsumer() {
        java.util.function.Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, Consumer!"); // Output: Hello, Consumer!
    }

    //other exmaple
        public void methodWithConsumer2() {
            java.util.function.Consumer<Integer> squareConsumer = x -> System.out.println(x * x);
            squareConsumer.accept(5); // Output: 25
        }
}

class CustomConsumerExample {
    @FunctionalInterface
    interface MyConsumer {
        void accept(int x);
    }

     public void methodWithCustomConsumer() {
        MyConsumer printSquare = x -> System.out.println(x * x); // Lambda expression that implements the accept method
        printSquare.accept(5); // Output: 25
    }
}

class SupplierExample {
    // Purpose: Takes no input and returns a result of type T.
    // Single abstract method: T get()
    // Use case: Used for generating or supplying values.

     public void methodWithSupplier() {
        java.util.function.Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get()); // Output: Random number: 0.123456789 (example)
    }
}

class CustomSupplierExample {
    @FunctionalInterface
    interface MySupplier {
        int get();
    }

     public void methodWithCustomSupplier() {
        MySupplier randomIntSupplier = () -> (int) (Math.random() * 100); // Lambda expression that implements the get method
        System.out.println("Random integer: " + randomIntSupplier.get()); // Output: Random integer: 42 (example)
    }
}

class BiFunctionExample {
    // Purpose: Takes two inputs of types T and U and returns a result of type R.
    // Single abstract method: R apply(T t, U u)
    // Use case: Used for combining or transforming two pieces of data.

     public void methodWithBiFunction() {
        java.util.function.BiFunction<Integer, Integer, Integer> addFunction = (x, y) -> x + y;
        System.out.println("Sum of 5 and 3: " + addFunction.apply(5, 3)); // Output: Sum of 5 and 3: 8
    }

    // different example
    public void methodWithBiFunction2() {
        java.util.function.BiFunction<String, String, String> concatFunction = (s1, s2) -> s1 + s2;
        System.out.println("Concatenation of 'Hello' and 'World': " + concatFunction.apply("Hello", "World")); // Output: Concatenation of 'Hello' and 'World': HelloWorld
    }

    // difference between BiFunction and Function? - The main difference between BiFunction and Function is that
    // BiFunction takes two input parameters and returns a result,
    // while Function takes only one input parameter and returns a result.
    // BiFunction is used when you need to combine or transform two pieces of data,
    // whereas Function is used when you need to transform a single piece of data.
}

class BiConsumerExample {
    // Purpose: Takes two inputs of types T and U and performs an action without returning a result.
    // Single abstract method: void accept(T t, U u)
    // Use case: Used for performing operations on two pieces of data, such as printing or modifying objects.

     public void methodWithBiConsumer() {
        java.util.function.BiConsumer<String, String> printBiConsumer = (s1, s2) -> System.out.println(s1 + " " + s2);
        printBiConsumer.accept("Hello", "BiConsumer!"); // Output: Hello BiConsumer!
    }

   // what is T means - In the context of functional interfaces, T is a type parameter that represents a generic type. It is a placeholder for the actual type that will be used when the functional interface is implemented. For example, in the Consumer<T> functional interface, T can be any type (e.g., String, Integer, etc.), and when you implement the Consumer interface, you specify the actual type you want to use. This allows for flexibility and reusability of the functional interface with different types of data.
   // what is U means - Similar to T, U is another type parameter that represents a second generic type in functional interfaces that take two inputs, such as BiFunction<T, U, R> or BiConsumer<T, U>. It serves as a placeholder for the actual type of the second input parameter when the functional interface is implemented. This allows you to use the same functional interface with different combinations of input types.
}

// what is chaining - Chaining in the context of functional interfaces and lambda expressions refers to the ability to combine multiple operations or functions together in a sequence. This is often achieved using methods like andThen() or compose() for Function interfaces, or using method references and lambda expressions to create a pipeline of operations. For example, you can chain multiple Function instances together to perform a series of transformations on data, where the output of one function becomes the input of the next function in the chain. This allows for more concise and readable code when performing complex operations on data.

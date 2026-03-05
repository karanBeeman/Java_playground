package java_ground.lambda_streams;

import java.util.function.Function;

public class LambdaChaining {

    public static void main(String[] args) {
        FunctionChaining functionChaining = new FunctionChaining();
        functionChaining.functionChainingMethod();

        PredicateChaining predicateChaining = new PredicateChaining();
        predicateChaining.predicateChainingMethod();

        ConsumerChaining consumerChaining = new ConsumerChaining();
        consumerChaining.consumerChainingMethod();

    }

}

class FunctionChaining {

    public void functionChainingMethod() {
        Function<Integer, Integer> add = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;

        // Chaining functions using andThen (first add method will be executed and then multiply method will be executed)
        Function<Integer, Integer> addThenMultiply = add.andThen(multiply);
        System.out.println(addThenMultiply.apply(5));

        // Chaining functions using compose (first multiply method will be executed and then add method will be executed)
        Function<Integer, Integer> multiplyThenAdd = add.compose(multiply);
        System.out.println(multiplyThenAdd.apply(5));

    }
}

class PredicateChaining {

    public void predicateChainingMethod() {
        java.util.function.Predicate<Integer> isEven = x -> x % 2 == 0;
        java.util.function.Predicate<Integer> isGreaterThan5 = x -> x > 5;

        // Chaining predicates using and (both conditions must be true)
        java.util.function.Predicate<Integer> isEvenAndGreaterThan5 = isEven.and(isGreaterThan5);
        System.out.println(isEvenAndGreaterThan5.test(6)); // true
        System.out.println(isEvenAndGreaterThan5.test(4)); // false

        // Chaining predicates using or (at least one condition must be true)
        java.util.function.Predicate<Integer> isEvenOrGreaterThan5 = isEven.or(isGreaterThan5);
        System.out.println(isEvenOrGreaterThan5.test(6)); // true
        System.out.println(isEvenOrGreaterThan5.test(4)); // true
        System.out.println(isEvenOrGreaterThan5.test(3)); // false

        // Chaining predicates using negate (negates the condition)
        java.util.function.Predicate<Integer> isNotEven = isEven.negate();
        System.out.println(isNotEven.test(6)); // false

    }
}

class ConsumerChaining {

    public void consumerChainingMethod() {
        java.util.function.Consumer<String> printConsumer = s -> System.out.println(s);
        java.util.function.Consumer<String> toUpperCaseConsumer = s -> System.out.println(s.toUpperCase());

        // Chaining consumers using andThen (both consumers will be executed in order)
        java.util.function.Consumer<String> printThenToUpperCase = printConsumer.andThen(toUpperCaseConsumer);
        printThenToUpperCase.accept("Hello, Consumer!"); // Output: Hello, Consumer! HELLO, CONSUMER!

    }
}

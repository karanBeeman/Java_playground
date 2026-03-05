package java_ground.lambda_streams;

import java.util.function.Function;

public class ArgsExpressionVsArgsStatement {

    public static void main(String[] args) {
        // Args expression
        Runnable argsExpression = () -> System.out.println("This is an args expression");

        // Args statement
        Runnable argsStatement = () -> {
            System.out.println("This is an args statement");
        };

        argsExpression.run();
        argsStatement.run();

        //(args) -> expression
        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // Output: 25

        // (args) -> { statements }
        Function<Integer, Integer> complexFunction = x -> {
            int result = x * x;
            System.out.println("Calculating square of " + x);
            return result; // Must explicitly return
        };

        System.out.println(complexFunction.apply(5));
        // Output:
        // Calculating square of 5
        // 25

    }

}

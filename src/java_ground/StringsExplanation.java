package java_ground;

public class StringsExplanantion {

    public static void main(String[] args) {

        String s = "hello"; // creates new object and goes to string pool at compile time
        //s = "world"; // creates new object and goes to string pool
        String s1 = "hello"; // now new object is not created since "hello" object already in string pool
        // now both s and s1 points to same object

        String s2 = new String("hello"); // now new object is created in heap at runtime
        String s3 = new String("hello"); // again new object is created in heap at runtime
        System.out.println("For strings equals() compare content " + (s2.equals(s3)));

        String s4 = "karan world"; // new object created in string pool at compile time
        String s5 = "karan"; // new object created in string pool at compile time
        s5 += " world"; // now comes the twist - s5 is concatenated with 'world' which will happen at runtime
        // so it will store in heap
        //s5 = s5 + " world" or s5 += " world" will internally uses s5 = new StringBuilder(s5).append(" world").toString();


        System.out.println("comparing s4 and s5 using == " + (s4 == s5));
        System.out.println("comparing s4 and s5 using equals() " + (s4.equals(s5)));


        System.out.println("StringsExplanantion: " + (s == s1));
        System.out.println("StringsExplanantion: " + (s1 == s2));
    }
}

class StringBuilderExplanation {

    // StringBuilder is mutable can modify the same object

 public static void main(String[] args) {
     StringBuilder s1 = new StringBuilder("hello");
     StringBuilder s2 = new StringBuilder("hello");
     System.out.println(s1.equals(s2));
 }


}

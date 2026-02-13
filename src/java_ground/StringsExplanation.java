package java_ground;

public class StringsExplanation {

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
        // so s5 will point to new object in heap and s4 will point to string pool object, so they are different objects


        System.out.println("comparing s4 and s5 using == " + (s4 == s5));
        System.out.println("comparing s4 and s5 using equals() " + (s4.equals(s5)));


        System.out.println("StringsExplanantion: " + (s == s1));
        System.out.println("StringsExplanantion: " + (s1 == s2));
    }
}

class StringBuilderExplanation {
    // StringBuilder introduced in java 1.5
// StringBuilder is MUTABLE - can modify the same object, no new object creation for every append/insert/delete.
    //new StringBuilder("hello"); "hello" literals stored in string pool and new StringBuilder("hello")
        //Copies characters from the pooled "hello" into its internal char array char[] in the heap memory
    // Not thread-safe and not synchronized (faster than StringBuffer)
    // equals() for StringBuilder does not consider string for comparison, it still consider as object.
// By default array size is 16 (internally) and if we append more than 16 characters,
// it will create new array with size (old capacity * 2) + 2 and copy old array to new array and then append new character.

  public static void main(String[] args) {
     StringBuilder s1 = new StringBuilder("hello");
     StringBuilder s2 = new StringBuilder("hello");
     System.out.println(s1.equals(s2)); // false - stringbuffer does not override equals method() or hashCode()
     System.out.println(s1.toString().equals(s2.toString()));
  }
}

class StringBufferExplanation {

    // StringBuffer introduced in java 1.0
    // StringBuffer is same as StringBuilder but it is thread-safe (synchronized) and hence slower than StringBuilder.
    // StringBuffer = Automatic car (safe but slightly slower)
    // StringBuilder = Manual car (faster but you must handle control)
    // StringBuffer synchronizes all its methods internally, ensuring only one thread can modify the object at a time.

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("hello");
        StringBuffer s2 = new StringBuffer("hello");
        System.out.println(s1.equals(s2)); // false - stringbuffer does not override equals method() or hashCode()
        System.out.println(s1.toString().equals(s2.toString()));
    }
}
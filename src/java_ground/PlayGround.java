package java_ground;

public class PlayGround {

        public static void main(String[] args) {

            String a = "jk"; // string pool memory [jk]
            a += "karan"; // String pool memory [jk, karan, jk karan] - new string object created in string pool memory and reference variable a is now pointing to that new object [jk karan]

            System.out.println(a);

            int x = 10;
            x = 11;
            System.out.println(x);

            String s = "Hello World"; // string pool memory [Hello World]
            String s2 = "Hello World"; // string pool

            String s3 = new String("Hello World"); // heap memory

            System.out.println(s == s2); // true
            System.out.println(s == s3); // false

            System.out.println(s.equals(s3)); // true

            String s4 = new String("Hello World"); // heap memory separate object
            String s5 = new String("Hello World"); // heap memory separate object

            System.out.println(s4.equals(s5)); // true
            System.out.println(s4 == s5); // false

            Test t1 = new Test("karan"); // heap memory
            Test t2 = new Test("karan"); // heap memory
            System.out.println(t1.equals(t2)); // true - we have overridden equals() method to compare content of name variable
            System.out.println(t1.hashCode() == t2.hashCode());
            System.out.println(t1.getName().equals(t2.getName()));
            System.out.println(t1 == t2); // false

        }

}

class Test {

    String name;

        public Test(String name) {
            this.name = name;
        }

    public String getName() {
        return name;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Test test)) {
//            return false;
//        }
//        return Objects.equals(name, test.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(name);
//    }
}
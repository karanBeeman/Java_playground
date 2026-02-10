package dsa_ground;

// Equals method generally compares the object, (until unless it is overridden)
/*     public boolean equals(Object obj) {
            return this == obj;  // compares memory addresses
       }
*/

import java.util.Objects;

public class EqualsMethodExplanation {

  public static void main(String[] args) {
      Person p1 = new Person("Alice", 10);
      Person p2 = new Person("Alice", 10);

      System.out.println(p1.equals(p2)); // false, because references differ
      // Here equals method tries to compare the object points to same memory location.

      String s1 = new String("Alice");
      String s2 = new String("Alice");
      System.out.println(s1.equals(s2)); // true
      // Here String internally overrides the equals method so that the content is compared.
  }

}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /* Without overriding line 18 will return false */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference
        if (!(o instanceof Person person)) return false; // type check + cast in one line
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}

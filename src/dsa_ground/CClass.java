package dsa_ground;

import java.util.HashSet;
import java.util.Set;

public class CClass {

    public static void main(String[] args) {
        AClass obj = new BClass(); // with class A reference we are creating obj for class b
        obj.method();

        obj.method2();

        AClass obj2 = new AClass("karan"); //new object
        AClass obj3 = new AClass("karan"); // new object
        System.out.println("== " + (obj2 == obj3));
        System.out.println("equals " + obj2.equals(obj3)); //

        Set<AClass> set = new HashSet<>();
        set.add(obj2);
        set.add(obj3);
        set.add(obj2); // this will get rejected because of duplicate

        for (AClass aClass : set) {
            System.out.println(aClass.name);
        }

        System.out.println(obj2.equals(obj3));

    }



}

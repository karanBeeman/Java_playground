package java_ground.collection_framework.list;

import java.util.LinkedList;

// few methods with List doesnot have

//addFirst()
//addLast()
//removeFirst()
//removeLast()
//getFirst()
//getLast()

public class LinkedListLearning {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for(String element : list) {
            System.out.println(element);
        }
        list.remove("B");
        for(String element : list) {
            System.out.println(element);
        }
        list.addFirst("X");
        list.addLast("Y");
        for(String element : list) {
            System.out.println(element);
        }

    }

}

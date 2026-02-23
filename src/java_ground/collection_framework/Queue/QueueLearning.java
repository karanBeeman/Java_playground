package java_ground.collection_framework.Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class QueueLearning {


    public static void main(String[] args) {
        // 1 - perform enqueue and dequeue operations
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        queue.poll();

        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("peek retrieves head " + queue.peek());

        // 2 - print first element of the queue without removing it

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(3);

        System.out.println("First element of the queue: " + queue2.peek());

        // 3 - reverse a queue using stack
        Queue<Integer> queue1 = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        // Add elements to queue
        queue1.add(11);
        queue1.add(12);
        queue1.add(13);

        System.out.println("Original Queue: " + queue1);

        // Step 1: Move from Queue → Stack
        while (!queue1.isEmpty()) {
            stack.push(queue1.remove());
        }

        // Step 2: Move from Stack → Queue
        while (!stack.isEmpty()) {
            queue1.add(stack.pop());
        }

        System.out.println("Reversed Queue: " + queue1);

        // Palindrome
            String str = "madam";
            Queue<Character> queue3 = new LinkedList<>();
            Stack<Character> stack1 = new Stack<>();

            for (char c : str.toCharArray()) {
                queue3.offer(c);
                stack1.push(c);
            }

            boolean isPalindrome = true;
            while (!queue3.isEmpty()) {
                if (!queue3.poll().equals(stack1.pop())) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println("Is the string a palindrome? " + isPalindrome);

            // Print numbers from 1 to N using a queue
             int n = 5;
             int i = 1;

             Queue<Integer> list = new ArrayDeque<>();

             while (i <= n) {
                 list.offer(i);
                 i++;
             }
        System.out.println("Numbers from 1 to " + n + ": " + list);

    }


}

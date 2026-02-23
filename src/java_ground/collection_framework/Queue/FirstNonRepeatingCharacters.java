package java_ground.collection_framework.Queue;

// Problem statement: Given a stream of characters, print first non-repeating char at each step


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacters {

    public static void main(String[] args) {
        String stream = "aabcbd";

        int[] freq = new int[256]; // For ASCII characters
        Queue<Character> queue = new LinkedList<>();

        for (char ch : stream.toCharArray()) {

            // Increase frequency
            freq[ch]++;

            // Add to queue
            queue.offer(ch);

            // Remove repeating characters from front
            while (!queue.isEmpty() && freq[queue.peek()] > 1) {
                queue.poll();
            }

            // Print result
            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }

        String stream1 = "aabcbd";
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue1 = new LinkedList<>();
        for (char ch1 : stream1.toCharArray()) {
            if(map.containsKey(ch1)) {
                map.put(ch1, map.get(ch1) + 1);
            }
            //map.put(ch1, map.getOrDefault(ch1, 0) + 1); morden way instead of above if condition
            else {
                map.put(ch1, 1);
            }
            queue1.offer(ch1);

            while(!queue1.isEmpty() &&  map.get(queue1.peek()) > 1) {
                 queue1.poll();
            }

            if (queue1.isEmpty()) {
                System.out.println("-1 ");
            } else {
                System.out.println(queue1.peek() + " ");
            }
        }
    }

}

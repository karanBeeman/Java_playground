package dsa_ground.arrays.primitives;

import java.util.HashMap;
import java.util.Map;

///Problem Statement

//Given an array of integers, find the first element that does not repeat in the array.
//If no such element exists, return -1.

//Example

//Input:
//arr = [9, 4, 9, 6, 7, 4]

//Output:
//6

///Algorithm
// Input: An array of n integers
// Create an empty map/dictionary called freqMap to store frequency of elements
// Traverse the array:
//    a. For each element, check if it exists in freqMap
//    b. If yes, increment its value by 1
//    c. If no, add it to freqMap with value 1
// Traverse the array again:
//    a. For each element, check its frequency in freqMap
//    b. If frequency == 1
//            - Print the element as the first non-repeating element
//            - Stop the loop
// If no element with frequency 1 is found, print "No non-repeating element

///Complexity
// O(n + n) = O(2n)
// Big-O notation Doesnot consider constant so O(n)

/// Linear/traverse
/// Hashing/Frequency count

public class FindFirstNonRepeatingElement {

    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4};

        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency manually
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];

            if (freqMap.containsKey(key)) {
                freqMap.put(key, freqMap.get(key) + 1);
            } else {
                freqMap.put(key, 1);
            }
        }

        // Step 2: Find first non-repeating element
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (freqMap.get(arr[i]) == 1) {
                System.out.println("First non-repeating element: " + arr[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No non-repeating element");
        }
    }
}

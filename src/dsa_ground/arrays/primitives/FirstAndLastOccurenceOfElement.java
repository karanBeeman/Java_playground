package dsa_ground.arrays.primitives;

//Problem: In a sorted array, find the first and last index of a given target element. Return -1, -1 if not found.

//Example:
//Input: arr = [1, 2, 2, 2, 3], target = 2 → Output: first = 1, last = 3

import java.util.HashMap;
import java.util.Map;

/// Algorithm
/*
  Given Array of n elements
  Given a target = 2
  Initialize variables
       first = -1
       last = -1
  Initialize an empty map
  For each element
      check element == target
      if yes
         store it in a map, index as key and target as value
  Iterate the map a print the first and last occurrence
*/

/// Complexity
// O(n)

/// Linear/traverse

public class FirstAndLastOccurenceOfElement {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 5, 6, 7, 2, 9};
        int target = 2;
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;   // first time found
                }
                last = i;        // keeps updating
            }
        }
        System.out.println("First Index: " + first);
        System.out.println("Last Index: " + last);
    }
}

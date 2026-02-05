package dsa_ground.arrays.primitives;

//Problem Statement
//Given an array of integers and a target value, find all pairs of numbers whose sum is equal to the target.

//Example
//Input:
//arr = [2, 7, 11, 15], target = 9

//Output:
//(2, 7)

//Constraints
//Each pair should be counted once.
//Order of elements does not matter.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// Algorithm
/*
Initialize data structures:

  A map (map) to store numbers we have seen so far and their indices.
  A list (list) to store the pairs that sum to the target.
  Iterate through the array:
      For each element num in the array:
          Compute its complement with respect to the target: complement = target - num.
          Check if the complement exists in the map:
             If yes, a valid pair is found → add (complement, num) to the result list.
          Store the current element in the map for future reference.
  Return or print the list of pairs.
 */

/// PseudoCode
/*
 FUNCTION findPairs(arr, target):
    CREATE map as empty dictionary
    CREATE list as empty list

    FOR each number in arr:
        complement = target - number
        IF complement exists in map:
            ADD (complement, number) to list
        ENDIF
        map[number] = true   // store number in map
    ENDFOR

    RETURN list
END FUNCTION
 */

/// Complexity
// O(n)

/// Hashing technique

public class TwoSumProblem {

    public static void main(String[] args) {

        int[] arr = {2, 4, 5, 7};
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                list.add("(" + complement + ", " + arr[i] + ")");
            }
            map.put(arr[i], i);
        }
        System.out.println(list);
    }

}

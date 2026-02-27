package dsa_ground.arrays.primitives.binary_search;

/// Problem:
//Given a sorted array that may contain duplicates, find the first occurrence of a given element.

//Example:
//arr = {1, 2, 2, 2, 3}
//target = 2
//Output: 1

/// Algorithm
/*
   Input: Given an array of n elements
   Given target = 2;
   For each element
      check if element == target
      Print the arr[element]
      break;
 */

/// PseudoCode for linear/traverse
/*
 START
   Given an array of n elements
   target = 2;
   FOR i To n-1 DO
     i == target;
     PRINT the arr[i];
     break;
   END FOR
END
 */

/// PseudoCode for Binary search
/*
START
    INPUT: sorted array arr[0...n-1], target
    SET low = 0
    SET high = n - 1
    SET first = -1        // stores the first occurrence index, -1 if not found

    WHILE low <= high
        SET mid = low + (high - low) / 2

        IF arr[mid] == target THEN
            first = mid        // possible first occurrence
            high = mid - 1     // continue searching left
        ELSE IF arr[mid] < target THEN
            low = mid + 1      // search right half
        ELSE
            high = mid - 1     // search left half
        END IF
    END WHILE

    OUTPUT first   // -1 if target not found
END
 */

public class FirstOccurrenceOfElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 6};
        int target = 6;

// THIS BELONGS TO LINEAR SEARCH BECAUSE O(n), IF THE ARRAY SIZE IS BIG, IT LOOPS EVERY ELEMENT

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == target) {
//                System.out.println(i);
//                break;
//            }
//        }

// HERE COMES THE BINARY SEARCH O(log n)
/// NOTE: BINARY SEARCH ONLY WORKS ON SORTED ARRAY
        int low = 0;
        int high = arr.length - 1;
        int first = -1; // to store the index of first occurrence, initialized to -1 to indicate not found

        while (low <= high) {
            int mid = low + (high - low) / 2; // to avoid overflow, instead of (low + high) / 2
            // mid = 0 + (5 - 0) / 2 = 2, arr[mid] = 2, first = 2, high = 1
            // mid = 0 + (1 - 0) / 2 = 0, arr[mid] = 1, low = 1, high = 1
            // mid = 1 + (1 - 1) / 2 = 1, arr[mid] = 2, first = 1, high = 0
            // low = 1, high = 0, loop ends, first = 1
            if (arr[mid] == target) {
                first = mid; // first possible occurrence
                // assuming target is 2 and condition passes
                // either it first occurrence or may be the mid or last element
                // but our aim is to find occurrence then we definitely guarantee it should be below that
                // that why high to mid-1
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(first);
    }



}

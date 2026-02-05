package dsa_ground.arrays.primitives.binary_search;

/// Problem:
//Given a sorted array and a target value, count the number of times the target appears.

//Example:
//arr = {1, 2, 2, 2, 3}
//target = 2
//Output: 3

/// Algorithm
/*
   Input: Given an array of n elements
   target = 2;
   Initialize a variable
      count = 0;
   For each element check
      if element == target
          count++;
   After the loop ends, print the count
 */

/// PseudoCode for linear/traverse
/*
START
   Given an array of elements
   SET count = 0;
   FOR i TO n-1 DO
     IF i == target
        count++
   END FOR
   PRINT the count
 */

/// PseudoCode
/*
START
    INPUT: sorted array arr[0...n-1], target
    SET first = -1
    SET last = -1

    // Step 1: Find first occurrence
    SET low = 0
    SET high = n - 1
    WHILE low <= high
        SET mid = low + (high - low)/2
        IF arr[mid] == target THEN
            first = mid
            high = mid - 1      // search left for earlier occurrence
        ELSE IF arr[mid] < target THEN
            low = mid + 1       // search right
        ELSE
            high = mid - 1      // search left
        END IF
    END WHILE

    // Step 2: Find last occurrence
    SET low = 0
    SET high = n - 1
    WHILE low <= high
        SET mid = low + (high - low)/2
        IF arr[mid] == target THEN
            last = mid
            low = mid + 1       // search right for later occurrence
        ELSE IF arr[mid] < target THEN
            low = mid + 1
        ELSE
            high = mid - 1
        END IF
    END WHILE

    // Step 3: Calculate count
    IF first == -1 THEN
        count = 0       // target not found
    ELSE
        count = last - first + 1
    END IF

    OUTPUT count
END
*/

/// Complexity
// O(log n) + O(log n) = 2 * O(log n)
// Drop the constant so O(log n)

public class CountOccurrenceOfElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 5, 6, 2, 8, 2, 10};
        int target = 2;
        int count = 0;
// THIS IS LINEAR SEARCH O(n)
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == target) {
//                count++;
//            }
//        }
//        System.out.println(count);

/// BINEARY SEARCH - FIRST OCCURRENCE
//        int low = 0, high = arr.length - 1;
//        int first = -1;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            if (arr[mid] == target) {
//                first = mid;       // possible first
//                high = mid - 1;    // search left
//            } else if (arr[mid] < target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }

///  LAST OCCURRENCE
//        low = 0;
//        high = arr.length - 1;
//        int last = -1;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            if (arr[mid] == target) {
//                last = mid;        // possible last
//                low = mid + 1;     // search right
//            } else if (arr[mid] < target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//    }

/// COUNT THE OCCURRENCE
//        if (first == -1) {
//            count = 0;  // target not found
//        } else {
//            count = last - first + 1;
//        }
    }

}

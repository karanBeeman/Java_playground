package dsa_ground.arrays.primitives;

//Problem Statement:
//Given an array of integers and a number X, count how many elements in the array are strictly greater than X.

//Input:
//Array of integers
//Integer X

//Example:
//Input:
//    5
//    3 7 1 9 4
//X = 4

/// Algorithm
/*
 Input: Given array of n elements
 Given a variable x = 4 which the value to compare
 For each element check
     if element is > x
     print element
*/

/// PseudoCode
/*
START
  Input array of n elements
  x = 4
    FOR i = 0 TO n-1
      IF i > x
      PRINT i
    END FOR
END
 */

/// Complexity
// O(n)

public class NoOfElementGreaterThanX {

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 4, 9};
        int x = 4;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                System.out.println(arr[i]);
            }
        }
    }

}

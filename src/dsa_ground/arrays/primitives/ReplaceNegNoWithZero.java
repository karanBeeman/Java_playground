package dsa_ground.arrays.primitives;

//Problem Statement:
//Given an integer array of size N, replace every negative number in the array with 0.

//Input:
//First line: integer N
//Second line: N space-separated integers

//Output:
//Print the modified array after replacement.

/// Algorithm
/*
  Input: given an array of n elements
  For each element check
      if element is < 0 (which means negative number)
      Replace the element with zero
  After loop ends print the updated array
 */

/// PseudoCode
/*
 START
 Given array of n elements
   FOR n To n-1
     IF arr[i] < 0
     arr[i] = 0
   END FOR
   FOR n To
   PRINT updated array
 END
 */

/// Complexity
// O(n + n) = O(n)

/// Linear/traverse array

public class ReplaceNegNoWithZero {
    public static void main(String[] args) {
        int[] arr = {1,2,-3,4,-5,6,-7};

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                arr[i] = 0;
            }
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }

}

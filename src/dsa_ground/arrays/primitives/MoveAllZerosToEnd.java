package dsa_ground.arrays.primitives;

///Problem Statement
//Given an array of integers, move all 0s to the end of the array while maintaining the relative order of non-zero elements.

//Example
//Input:
//arr = [0, 1, 0, 3, 12]

//Output:
//[1, 3, 12, 0, 0]

//Constraints
//Do it in-place.
//Minimize the number of operations.

///Algorithm
/*
 Input : Given array of n elements
 Initialize variable -> nonzerovalue = 0
 For each element check
     if element != 0
       assign  arr[nonzerovalue] = element
       increment nonZeroValue by 1
 After loop starts fill remaining positions with 0:
       WHILE nonZeroIndex < n:
             - arr[nonZeroIndex] = 0
             - Increment nonZeroIndex by 1
 print the updated array */

///PseudoCode
/*
START
 Input array of n elements
 nonZeroIndex = 0

// Step 1: Move non-zero elements to the front
    FOR i = 0 TO n-1
       IF arr[i] != 0
          arr[nonZeroIndex] = arr[i]
           nonZeroIndex = nonZeroIndex + 1
       END IF
    END FOR

// Step 2: Fill remaining positions with zeros
    WHILE nonZeroIndex < n
         arr[nonZeroIndex] = 0
         nonZeroIndex = nonZeroIndex + 1
    END WHILE

    PRINT updated array
    END */

/// complexity
// O(n + n) = O(2n) but consideer as O(n)

import java.util.Arrays;

public class MoveAllZerosToEnd {

    public static void main(String[] args) {
       int[] arr = {0, 1, 0, 3, 12};
       int nonZeroValues = 0;
       for (int i = 0; i < arr.length; i++) {
           if(arr[i] !=0) {
               arr[nonZeroValues++] = arr[i];
           }
       }

       while (nonZeroValues < arr.length) {
           arr[nonZeroValues++] = 0;
       }

        System.out.println(Arrays.toString(arr));
    }

}

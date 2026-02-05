package dsa_ground.arrays.primitives;

///Problem Statement:
//Given an integer array of size N, convert all odd numbers into even numbers by adding 1 to each odd element.

//Input:
//Integer N
//N space-separated integers

//Output:
//Print the updated array.
//Example:
//Input:
// 5
// 3 6 7 10

///Algorithm
/*
  Initialize an array
  loop the array
  For each element:
      a. Check if the element is odd (element % 2 != 0).
      b. If it is odd, increment the element by 1 to make it even.
  After processing all elements, print the updated array. */

///PseudoCode
/*
START
 Input array of n integers

 FOR each element in array
 IF element % 2 != 0
    element = element + 1
 END FOR

 PRINT "Updated array"
END
*/

///complexity
// O(n) - means the algorithm’s running time grows linearly with the input size.

/// Linear/traverse array

public class AllOddNoToEvenNumbers {
    public static void main(String[] args) {
        int[] arr = {3,6,7,10,9};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = arr[i] + 1;
            }
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
}

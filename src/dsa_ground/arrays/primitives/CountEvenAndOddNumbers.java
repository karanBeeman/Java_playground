package dsa_ground.arrays.primitives;

///Problem Statement:
//Given an array of integers, count and print the number of even and odd elements in the array.
//
//    Example:
//Input:
//    5
//    1 2 3 4 5
//Output:
//Even = 2
//Odd = 3

///Algorithm
/* --
 Input: An array of n integers.
 Initialize two integer variables:
    - even = 0
    - odd = 0
 For each element in the array:
    a. If the element is divisible by 2 (element % 2 == 0)
         - Increment even by 1
    b. Else
         - Increment odd by 1
 Print the values of even and odd  -- */


///PesudoCode
/*
START

 Input array of n integers
 even = 0
 odd = 0

 FOR each element in array
 IF element % 2 == 0
   even = even + 1
 ELSE
    odd = odd + 1
 END FOR

 PRINT "Even count: ", even
 PRINT "Odd count: ", odd

END */

///Complexity
// O(n)

/// Linear/traverse array

public class CountEvenAndOddNumbers {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7};
        int odd = 0;
        int even = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println(odd + " " + even);
    }
}

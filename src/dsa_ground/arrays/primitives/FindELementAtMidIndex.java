package dsa_ground.arrays.primitives;

///Problem Statement:

//Given an integer array of size N, print the element present at the middle index.

//Note:
//If N is odd → middle index = N / 2
//If N is even → print the element at index N / 2

///Algorithm
/*
 Input: An array of n elements
 Calculate middle index:
     middleIndex = n / 2
     (If n is even, middleIndex will be the higher middle element)
     (If n is odd, middleIndex will be exact middle element)
 Print the element at middleIndex */

///PseudoCode
/*
START
Input array of n elements

   IF n % 2 == 0
      middleIndex = n / 2   // higher middle element
   ELSE
      middleIndex = n / 2   // exact middle element
   END IF
PRINT "Middle element: ", array[middleIndex]

END  */

public class FindELementAtMidIndex {

    public static void main(String[] args) {
        int[] arr = {3,6,7,10,9};
        System.out.println(arr[arr.length/2]);

        int[] arr1 = {3,6,7,10,9,8};
        System.out.println(arr1[arr1.length/2]);
    }

}

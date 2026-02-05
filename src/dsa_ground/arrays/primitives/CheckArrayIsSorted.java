package dsa_ground.arrays.primitives;

//Problem: Check whether an array is sorted in ascending order.

//    Example:
//Input: [1, 2, 3, 4] → true
//Input: [1, 3, 2, 4] → false

///Algorithm
/*
 given n of array elements
 For each element,
    check if element is > next element if yes "array is not sorted"
    break the loop */

///pseudocode
/*
If n <= 1:
 Print "Array is sorted"
Exit

 Initialize a variable sorted = true
 For i = 0 to n - 2:
        If arr[i] > arr[i+1]:
        Print "Array is not sorted"
        Set sorted = false
        Break
 If sorted == true:
 Print "Array is sorted" */

///Complexity
// O(n)

/// Linear/traverse array

public class CheckArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = {3,6,7,10,9,8};

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("not sorted");
                break;
            }
        }
        System.out.println("sorted");
    }


}


package dsa_ground.arrays.primitives.two_pointers;

//Problem: Remove duplicates in-place from a sorted array. Return new length.

//Example:
//Input: [1, 1, 2, 2, 3]
//Output: [1, 2, 3]

/// Algorithm
/*
1. Input: A sorted array of n elements
2. Initialize index j = 0
3. Traverse the array from index i = 1 to n - 1:
       a. If arr[i] is not equal to arr[j]:
             - Increment j by 1
             - Assign arr[j] = arr[i]
4. After the loop, the number of unique elements is j + 1
5. Traverse the array from index 0 to j
6. Print the elements
*/

/// PseudoCode
/*
START
Input sorted array arr of n elements
j = 0

FOR i = 1 TO n-1
    IF arr[i] != arr[j]
        j = j + 1
        arr[j] = arr[i]
    END IF
END FOR

uniqueCount = j + 1

FOR i = 0 TO uniqueCount - 1
    PRINT arr[i]
END FOR

END */

/// Linear/traverse with Two pointer technique
// i -> traverse through every element
// j -> moves only when a new (unique) element is found

/// Complexity
// O(n)

// technique: Two pointertechnique

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 3, 4, 5, 6, 6 , 6};
        int j = 0; // slow pointer
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        j += 1;

        for (int i = 0; i < j; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

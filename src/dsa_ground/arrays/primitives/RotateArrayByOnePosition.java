package dsa_ground.arrays.primitives;

// Problem statement: Given an array, rotate the array to the right by one position.
// input: arr = [1, 2, 3, 4, 5]
// output: arr = [5, 1, 2, 3, 4]

// Algorithm:
/*
  For a given array of n integers
      1. Store the last element of the array in a temporary variable.
      2. Shift all elements of the array to the right by one position, starting from the end of the array and moving towards the beginning.
      3. Place the temporary variable (the last element) at the first position of the array.
 */

// pseudocode:
/*
function rotateArrayByOnePosition(arr):
    if length of arr == 0:
        return arr

    lastElement = arr[length of arr - 1]

    for i from length of arr - 1 down to 1:
        arr[i] = arr[i - 1]

    arr[0] = lastElement

    return arr
 */

// Edge cases:
// 1. If the array is empty, we can return the empty array as there are no elements to rotate.

// Time complexity: O(n) - We traverse the array once to shift the elements.
// Space complexity: O(1) - We use a constant amount of extra space for the temporary variable.

// Note: This algorithm modifies the original array in place, so it does not require additional space for another array to hold the rotated elements.

public class RotateArrayByOnePosition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        // i = 4, arr[4] = arr[3] → arr = [1, 2, 3, 4, 4]
        // i = 3, arr[3] = arr[2] → arr = [1, 2, 3, 3, 4]
        // i = 2, arr[2] = arr[1] → arr = [1, 2, 2, 3, 4]
        // i = 1, arr[1] = arr[0] → arr = [1, 1, 2, 3, 4]
        // i = 0, loop ends
        arr[0] = lastElement;

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}

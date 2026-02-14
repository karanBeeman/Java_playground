package dsa_ground.arrays.primitives;

//problem statement: Find the second largest element
// Input: arr = [3, 1, 4, 2, 5]
// Output: 4

// Algorithm:
/* For a given array of n integers
      1. Initialize two variables, largest and secondlargest, to hold the largest and second largest elements respectively.
        2. Iterate through the array:
             a. If the current element is greater than largest, update secondlargest to largest and largest to the current element.
             b. Else if the current element is greater than secondlargest and not equal to largest, update secondlargest to the current element.
        3. After the loop, secondlargest will hold the second largest element in the array.
 */

// pseudocode:
/*
function findSecondLargest(arr):
    if length of arr < 2:
        return "Error: Array must have at least 2 elements"

    largest = Integer.MIN_VALUE
    secondlargest = Integer.MIN_VALUE

    for each element in arr:
        if element > largest:
            secondlargest = largest
            largest = element
        else if element > secondlargest and element != largest:
            secondlargest = element

    return secondlargest
 */

// Edge cases:
// 1. If the array has less than 2 elements, we cannot find a second largest element. We can return an error message or a specific value (e.g., Integer.MIN_VALUE).

// Time complexity: O(n) - We traverse the array once.
// space complexity: O(1) - We use a constant amount of extra space for the variables.


public class FindSecondLargestElement {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5};
        Integer firstLargest = Integer.MIN_VALUE;
        Integer secondLargest = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = j;
            } else if (j > secondLargest && j != firstLargest) {
                secondLargest = j;
            }
        }
        System.out.println(secondLargest);
    }

}

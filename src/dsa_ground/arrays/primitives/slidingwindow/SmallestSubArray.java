package dsa_ground.arrays.primitives.slidingwindow;

// Problem: Given an array of positive integers and a positive integer target,
// find the length of the smallest contiguous subarray whose sum is greater than or equal to the target. If no such subarray exists, return 0.
// Example:
// Input: arr = [2, 3, 1, 2, 4, 3], target = 7
// Output: 2 (the subarray [4, 3] has the smallest length with a sum of 7)


public class SmallestSubArray {

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 4, 3};
        int sum = 0;
        int start = 0;
        int s = 7;
        int minLength = Integer.MAX_VALUE;

        // tell this logic in simple words
        // we are using two pointers, one pointer is the start pointer and the other pointer is the end pointer.
        // We are expanding the window by moving the end pointer and adding the current element to the sum.
        // When the sum is greater than or equal to the target, we are shrinking the window by moving the start pointer and subtracting the element at the start index from the sum.

        for (int end = 0; end < arr.length; end++) {
            sum = sum + arr[end]; // expanding the window by adding the current element to the sum

            while (sum >= s) {
                minLength = Math.min(minLength, end - start + 1);
                sum = sum - arr[start]; // shrinking the window by subtracting the element at the start index from the sum
                start++;
            }
        }

        if(minLength == Integer.MAX_VALUE) {
            System.out.println("no min element found");
        } else {
            System.out.println(minLength);
        }
    }

}

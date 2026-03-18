package dsa_ground.arrays.primitives.slidingwindow;

// Problem: Given an array of integers and a number k, find the maximum sum of a subarray of size k.
// Example:
// Input: [2, 1, 5, 1, 3, 2], k = 3
// Output: 9 (subarray [5, 1, 3])


public class MaxSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int maxValue;
        int minValue = 0;

        for(int i = 0; i < k; i++) {
            minValue += arr[i];
        }

        maxValue = minValue;

        for (int j = k; j < arr.length; j++) {
            minValue += arr[j] - arr[j - k];
            if (maxValue < minValue) {
                maxValue = minValue;
            }
        }

        System.out.println(maxValue);

    }

}

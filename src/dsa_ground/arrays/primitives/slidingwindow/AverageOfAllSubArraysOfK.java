package dsa_ground.arrays.primitives.slidingwindow;

// Problem: Given an array of integers and a number k, find the average of all contiguous subarrays of size k.
// Example:
// Input: [1, 3, 2, 6, -1, 4, 1, 8, 2], k = 5
// Output: [2.2, 2.8, 2.4, 3.6]

public class AverageOfAllSubArraysOfK {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        double sum = 0;

        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        System.out.println(sum / k);

        for (int j = k; j < arr.length; j++) {
            sum += arr[j] - arr[j - k];
            System.out.println(sum / k);
        }
    }

}

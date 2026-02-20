package dsa_ground.arrays.primitives;

// NOTE : Find the Single Missing Number (1 to N)
// Problem Statement: You are given an array of size N-1 containing numbers from 1 to N
// Input:  [1, 2, 4, 5]
// N = 5
// Output: 3

// time complexity : O(N)
public class FindMissingElement {

    public static void main(String[] args) {
        // using Sum formula → N*(N+1)/2
        int[] arr = {1,2,4,5};
        int n = 5;
        int expected_sum = n * (n+1)/2;
        int actual_sum = 0;

        for (int i : arr) {
            actual_sum += i;
        }

        System.out.println(expected_sum - actual_sum);

        // Using XOR
        int[] arr1 = {1, 2, 4, 5};
        int n1 = 5;

// XOR all numbers from 1 to n
        int xorFull = 0;
        for (int i = 1; i <= n1; i++) {
            xorFull ^= i;
        }

// XOR all numbers in the array
        int xorArr = 0;
        for (int num : arr1) {
            xorArr ^= num;
        }

// Missing number
        int missing = xorFull ^ xorArr;
        System.out.println(missing); // 3



    }

}

package dsa_ground.arrays.primitives.slidingwindow;

// Problem: Given a binary array and an integer k, find the maximum number of consecutive 1s in the array if you can flip at most k 0s to 1s.
// Example:
// Input: arr = [1, 0, 1, 1, 0, 1], k = 1
// Output: 4 (by flipping the second 0 to 1, we get the longest sequence of 1s as [1, 1, 1, 1])

public class MaxNoOf1SReplacingK0s {

    public static void main(String[] args) {

        int arr[] = {1, 0, 1, 1, 0, 1};
        int k = 1;
        int maxLength = 0;
        int start = 0;
        int zeroCount = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        System.out.println(maxLength);
    }

}

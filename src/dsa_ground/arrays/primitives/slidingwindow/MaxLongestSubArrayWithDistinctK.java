package dsa_ground.arrays.primitives.slidingwindow;

// problem: Given an array of integers and a number k, find the length of the longest subarray that contains at most k distinct integers.
// Example:
// Input: [1, 2, 1, 3, 4], k = 2
// Output: 3 (subarray [1, 2, 1])

public class MaxLongestSubArrayWithDistinctK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4};
        int k = 2;
        int maxLength = 0;
        int left = 0;
        java.util.Map<Integer, Integer> countMap = new java.util.HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            while (countMap.size() > k) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }

}

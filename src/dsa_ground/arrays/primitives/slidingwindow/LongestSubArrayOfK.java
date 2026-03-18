package dsa_ground.arrays.primitives.slidingwindow;

public class LongestSubArrayOfK {

    public static void main(String[] args) {
        int arr[] = {4, 2, 1, 7, 8, 1, 2, 8, 1};
        int sum = 0;
        int start = 0;
        int k = 8;
        int maxLength = 0;
        for (int end = 0; end < arr.length; end++) {

            sum += arr[end];

            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        System.out.println(maxLength);
    }
}

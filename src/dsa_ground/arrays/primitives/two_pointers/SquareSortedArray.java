package dsa_ground.arrays.primitives.two_pointers;

// Problem: Given a sorted array of integers, return an array of the squares of each number, also in sorted order.
// Example:
// Input: [-4, -1, 0, 3, 10]
// Output: [0, 1, 9, 16, 100]

// Technique: Two pointers

public class SquareSortedArray {

    public static void main(String[] args) {
        int [] arr = {-4, -1, 0, 3, 10};
        int left = 0;
        int right = arr.length-1;

        int [] result = new int[arr.length];
        while(left < right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare > rightSquare) {
                result[right-left] = leftSquare; // we are filling the result array from the end, so we are using right-left as index to fill the result array
                // wht right-left? because we are filling the result array from the end, so we are using right-left as index to fill the result array
                left++;
            } else {
                result[right-left] = rightSquare;
                right--;
            }
        }
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

}

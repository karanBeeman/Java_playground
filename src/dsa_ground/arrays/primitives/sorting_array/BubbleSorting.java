package dsa_ground.arrays.primitives.sorting_array;

// problem: sort the array in ascending order

public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = {5, 10, 1, 2, 4};
// Bubble sorting
        // It is efficient for small array, but not for larger arrays
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /// Complexity
    // O(n2) time complexity
    // O(1) space complexity

/*
    i = 0 -> j = 1 -> 5 > 10 ->no swap
    i =0 -> j =2 -> 5 > 2 -> no arr[0] = 1 and arr[2] = 5    [1,10,5
    i =0 -> j=3 -> 1 > 2 no swap
    i =0 -> j=4 -> 1 > 4 no swap [1,10,5,2,4]
    i =1 -> j=2 ->  10 > 5 -> arr[1] =5 and arr[2] = 10
    i =1 -> j=3 -> 5 > 2 -> arr[1] =2 and arr[3] = 5
    i =1 -> j=4 -> 2 > 4 no swap [1,2,10,5,4]
    i =2 -> j=3 -> 10 > 5 -> arr[2] =5 and arr[3]=10
    i =2 -> j=4 -> 5 > 4 -> arr[2] =4 and arr[4]=5 [1,2,4,10,5]
    i =3 -> j=4 -> 10 > 5 -> arr[3] =5 and arr[4]=10 [1,2,4,5,10]

 */

}

package dsa_ground.arrays.primitives.sorting_array;

/// Problem statement
// You are given an array of N integers.
// Your task is to sort the array in ascending order using the Selection Sort algorithm.

//Input
// Array = [64, 25, 12, 22, 11]

//Output
// [11, 12, 22, 25, 64]

/// Algorithm
/*
   Divide the array into two parts:
      A sorted part (initially empty)
      An unsorted part (initially the whole array)
   Repeatedly find the minimum element from the unsorted part.
   Swap it with the first element of the unsorted part.
   Move the boundary of the sorted part one position to the right.
   Continue until the entire array is sorted.
 */
public class SelectionSorting {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        for ( int a : arr) {
            System.out.print(a + " ");
        }
    }

}

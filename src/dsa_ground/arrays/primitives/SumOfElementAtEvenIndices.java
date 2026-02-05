package dsa_ground.arrays.primitives;

//Given an integer array of size N, find and print the sum of elements present at even indices.
////
////    Note:
////Indexing starts from 0.
////
////Example:
////Input:
////    5
////    10 20 30 40 50
////
////Output:
////    90
////    (Elements at indices 0, 2, 4 → 10 + 30 + 50

public class SumOfElementAtEvenIndices {

    public static void main(String[] args) {
        int evenIndices = 0;
        int[] arr = {3, 6, 7, 10, 9};

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenIndices += arr[i];
            }
        }
        System.out.println(evenIndices);
    }

}

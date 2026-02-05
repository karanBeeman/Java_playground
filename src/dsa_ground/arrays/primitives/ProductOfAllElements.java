package dsa_ground.arrays.primitives;

//Problem Statement:
//Given an integer array of size N, find and print the product of all elements of the array.
//
//    Note:
//If the array contains 0, the product will be 0.
//
//Example:
//Input:
// 4

import java.util.Scanner;

public class ProductOfAllElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        long product = 1;
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            product *= arr[i];
        }
        System.out.println(product);
    }

}

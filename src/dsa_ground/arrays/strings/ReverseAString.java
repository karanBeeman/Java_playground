package dsa_ground.arrays.strings;

//Problem Statement
//
//Given a string s, return the reverse of the string.
//
//    Example:
//Input: "Trimble"
//Output: "elbmirT"

import java.util.Arrays;
import java.util.Collections;

/// Algorithm
/*
   Start with a character array of length n.
Set two pointers:
  left at the beginning of the array (0)
  right at the end of the array (n – 1)
  While left is less than right:
  Swap the characters at the left and right positions
  Move left one step forward
  Move right one step backward
  When left and right meet or cross, the array is fully reversed.
 */

/// PseudoCode
/*
 START
Input: char array arr of size n

left ← 0
right ← n - 1

WHILE left < right DO
    // Swap elements at left and right
    temp ← arr[left]
    arr[left] ← arr[right]
    arr[right] ← temp

    // Move pointers toward the center
    left ← left + 1
    right ← right - 1
END WHILE

Print the array arr
END    */

/// Complexity
// O(n)

/// Two pointer technigue

public class ReverseAString {

    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        for (int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 -i];
            arr[arr.length - i -1] = temp;
        }
        System.out.println(arr);

        // streams
        char[] ar1 = {'h', 'e', 'l', 'l', 'o'};
        Character[] ar = new Character[ar1.length];
        for (int i = 0; i < ar.length; i++) ar[i] = ar1[i];
        Arrays.sort(ar, Collections.reverseOrder());
        System.out.println(Arrays.toString(ar));


        int left = 0;
        int right = arr.length - 1;

        // Use while loop to swap until left is no longer less than right
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println(arr);
    }

}

package dsa_ground.arrays.primitives.two_pointers;

/// Problem:
//Given an array arr and two indices l and r, reverse the elements from index l to r.

//Example:
//arr = {1, 2, 3, 4, 5}
//l = 1, r = 3
//Output: {1, 4, 3, 2, 5}

/// Algorithm
/*
  Input: Array of n elements
         variables l=1 and r =3;
  While l < r
     reserve the elements
 */

/// PseudoCode
/*
START
   Given array of n elements
   Given input l=1; r=3;

  WHILE l < r
    temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
    increment l by 1;
    decrement r by 1;
  END WHILE
  FOR i TO n DO
    PRINT arr[i]
  END FOR
END
*/

/// Complexity
// O(n) time complexity
// O(1) space complexity

/// Two pointer technique

public class ReverseASubArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int l = 1;
        int r = 3;

        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

package dsa_ground.arrays.primitives;

///Problem: Calculate the sum and average of all elements.

//Example:
//Input: [2, 4, 6, 8]
//Output: Sum = 20, Average = 5.0

///Algorithm
/* --- Input: An array of n integers
 Initialize two variables:
      a. sum = 0       // to store total sum
      b. avg = 0       // to store average
 For each element in the array:
      a. Add the element to sum
 Calculate average:
        avg = sum / n
 Print sum and avg  ----*/

///PseudoCode
/* START

 Input array of n elements
    sum = 0
    avg = 0

 FOR each element in array
    sum = sum + element
 END FOR

 avg = sum / n

 PRINT "Sum: ", sum
 PRINT "Average: ", avg

END */

///Complexity
// O(n)

/// Linear/traverse

public class FindSumAndAvgOfArrayElement {

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8};
        int sum = 0;
        int avg;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
        avg = sum / arr.length;
        System.out.println(avg);
    }

}

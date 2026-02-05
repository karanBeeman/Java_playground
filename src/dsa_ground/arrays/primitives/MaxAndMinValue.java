package dsa_ground.arrays.primitives;

///Algorithm
/* Input: given array of n elements
 Initialize two variables
    max = arr[0]
    min = arr[0]
 For each element check
     if element > max -> max = element
     if element < min -> min = element
 stop the loop
 Print max and min */

///PseudoCode
/*
START
Input array of n elements
    max = arr[0]
    min = arr[0]

FOR i = 1 TO n-1
   IF arr[i] > max
       max = arr[i]
   END IF
   IF arr[i] < min
       min = arr[i]
   END IF
END FOR
PRINT "Maximum element: ", max
PRINT "Minimum element: ", min
END */

///Complexity
// O(n)

/// Linear/traverse

public class MaxAndMinValue {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        System.out.println(max + " " + min);
    }
}

package dsa_ground.strings;

/// Problem:
//Given a string s, determine whether it is a palindrome.
//A palindrome is a string that reads the same forward and backward, ignoring case differences.

//Input
// A string s containing lowercase and/or uppercase letters.

//Output
//  Return true if the string is a palindrome.
//  Return false otherwise.

/// Algorithm
/*
  Input : Given a string s
  Initialize two variables
      left = 0
      right = arr.length-1
  While left < right
      check if s.charAt(left) != s.charAt(right)
       IF yes
         Print it is not palindrome
         break;
       Else
       left++;
       right--;
  If Loop didn't break then it is palindrome
 */


/// PseudoCode
/*
START
   Given a string s
   Initialize variables
     left = 0;
     right = s.length -1;
     boolean isPalindrome = true;
   WHILE left < right
      IF s.charAt(left) != s.charAt(right)
         isPalindrome = false;
         PRINT string is not palindrome;
         break;
      END IF
      left++;
      right--;
END
*/

/// Complexity
// O(n) - time complexity
// O(1) - space complexity

/// Two pointers technique

public class Palindrome {

    public static void main(String[] args) {

        String s = "malayalam";
    //    char[] arr = s.toCharArray(); space complexity O(n) to overcome this use charAt();
   //     The string s has n characters.
    //    toCharArray() creates a new character array of size n.
   //     That array lives in memory in addition to the original string

        int left = 0;
        int right = s.length()-1;
        boolean isPalindrome = true;

        while (left < right) {
           // if (arr[left] != arr[right]) { // no need for string to char array conversion, we can directly use charAt() method of string
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                System.out.println("not palindrome");
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) System.out.println("palindrome");
    }

}

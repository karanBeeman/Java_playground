package dsa_ground.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "abcabcbb";
        char[] input = str.toCharArray();

        Map<Character, Integer> freq = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < input.length; end++) {

            freq.put(input[end], freq.getOrDefault(input[end], 0) + 1);

            while (freq.get(input[end]) > 1) {
                freq.put(input[start], freq.get(input[start]) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println(maxLength);
    }

}

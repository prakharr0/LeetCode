package leetcode.random;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1624: Maximum Length Between Equal Characters

 * Given a string s, return the length of the longest substring between two equal characters,
 * excluding the two characters. If there is no such substring return -1.
 * A substring is a contiguous sequence of characters within a string.

 * Example 1:
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.

 * Example 2:
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".

 * Example 3:
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 */
public class MaxLengthBetweenEqualCharacters {

    /**
     * Store the count of first occurrence of a character. If the char has appeared earlier, calculate the distance
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() < 2) return -1;

        Map<Character, Integer> chars = new HashMap<>();

        int result = -1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (chars.containsKey(current)) {
                int firstIndex = chars.get(current);
                result = Math.max(result, i - firstIndex - 1);
            } else {
                chars.put(current, i);
            }

        }

        return result;
    }
}

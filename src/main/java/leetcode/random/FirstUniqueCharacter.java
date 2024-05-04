package leetcode.random;

/**
 * LeetCode 387: Find first unique character in a string

 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 * Example 1:
 * Input: s = "leetcode"
 * Output: 0

 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2

 * Example 3:
 * Input: s = "aabb"
 * Output: -1

 * Constraints:

 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 *
 * @author rathi.prakhar@outlook.com
 */
public class FirstUniqueCharacter {

    /**
     * Store the count, reiterate to find which char only appears once.
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}

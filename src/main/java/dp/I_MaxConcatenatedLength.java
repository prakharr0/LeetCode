package dp;

import java.util.List;

/**
 * LeetCode 1239: Max Length of a concatenated string with unique characters

 * You are given an array of strings arr. A string s is formed by the
 * concatenation of a subsequence of arr that has unique characters.

 * Return the maximum possible length of s.

 * A subsequence is an array that can be derived from another array by
 * deleting some or no elements without changing the order of the remaining
 * elements

 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.

 * Example 2:
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").

 * Example 3:
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.

 * Constraints:
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 *
 * @author rathi.prakhar@outlook.com
 */
public class I_MaxConcatenatedLength {

    public static void main(String[] args) {
        System.out.println(maxLength(List.of("e","tpgynpylqbyqjaf","svkgfmpgftxjjrcxxsog","bxypbbrlckiolfwpqgsoc","kwnelumrnnsryjdeppanuqbsu")));
    }

    /**
     * Use Dynamic Programming
     * At each index in the list of strings, i can either include it or ignore
     */
    public static int maxLength(List<String> arr) {
        int max = 0;
        return maxLength(arr, 0, max, "");
    }

    private static int maxLength(List<String> arr, int index, int max, String s) {
        // Base
        int n = s.length();

        // Proceed only if the current string is unique
        if (n > 0) {
            int[] chars = new int[26];

            for (char c: s.toCharArray()) {
                if (chars[c - 'a'] > 0) return max;
                chars[c - 'a']++;
            }

            // since it is unique
            max = Math.max(s.length(), max);
        }

        if (index >= arr.size()) return max;

        String current = arr.get(index);

        // Option 1: choose it
        s += current;
        int maxChosen = maxLength(arr, index + 1, max, s);

        // Option 2: ignore it
        s = s.substring(0, n);
        int maxIgnore = maxLength(arr, index + 1, max, s);

        max = Math.max(max, maxIgnore);
        max = Math.max(max, maxChosen);

        return max;
    }

}

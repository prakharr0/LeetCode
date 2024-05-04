package leetcode.random;

/**
 * LeetCode 1897: Redistribute characters to make strings equal

 * You are given an array of strings words (0-indexed).

 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string,
 * and move any character from words[i] to any position in words[j].

 * Return true if you can make every string in words equal using any number of operations, and false otherwise

 * Example 1:
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.

 * Example 2:
 * Input: words = ["ab","a"]
 * Output: false
 * Explanation: It is impossible to make all the strings equal using the operation.

 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */
public class I_MakeStringsEqual {

    /**
     * a character can appear n times in a word. If there are m identical words, the character appears m * n times.
     * Therefore, n % m == 0.

     * Count the frequency of all characters in the given words. If count[c] > 0 but n % m != 0 --> this is extra somewhere.
     */
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        int n = words.length;

        for (String s: words) {
            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            }
        }

        for (int c: count) {
            if (c > 0 && c % n != 0) return false;
        }

        return true;
    }
}

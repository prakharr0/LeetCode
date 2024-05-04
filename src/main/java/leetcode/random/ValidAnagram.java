package leetcode.random;

import java.util.Map;
import java.util.HashMap;

/**
 * LeetCode 242

 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 * An Anagram is a word or phrase formed by rearranging the letters of a different word or
 * phrase, typically using all the original letters exactly once.

 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true

 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false

 * @author rathi.prakhar@outlook.com
 */
public class ValidAnagram {

    /**
     * Store the count of chars in s in a map
     * Iterate over chars in t, if count of char < 1 ==> return char
     * Slower because we call get and put on a hashmap
     */
    public boolean isAnagramMap(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Integer> count = new HashMap<>();

        for (char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()) {

            if (count.containsKey(c) && count.get(c) > 0) {
                count.put(c, count.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Since there are max 256 characters. Use int[] count = new int[256] to store the count of each char in s
     * faster read and write access at a given location
     */
    public boolean isAnagramArray(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] count = new int[256];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            if (count[c - 'a'] < 1) return false;

            count[c - 'a']--;
        }

        return true;
    }
}

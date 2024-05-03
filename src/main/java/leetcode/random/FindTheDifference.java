package leetcode.random;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 389: <a href="https://leetcode.com/problems/find-the-difference/description/">Link</a>
 *
 * @author rathi.prakhar@outlook.com
 */
public class FindTheDifference {

    private char findTheDifference(String s, String t) {
        if (s == null || t == null) return Character.MIN_VALUE;
        return findTheDifferenceAsciiSum(s, t);
    }

    /**
     * Takes extra space for the HashMap
     * Store count of each character in s in a hashmap.
     * While traversing characters of t, if count for that character is 0 in the map ==> return
     */
    private char findTheDifferenceMap(String s, String t) {

        Map<Character, Integer> characters = new HashMap<>();

        for (char c: s.toCharArray()) {
            characters.put(
                    c,
                    characters.getOrDefault(c, 0) + 1
            );
        }

        for (char c: t.toCharArray()) {

            if (!characters.containsKey(c)) return c;

            int count = characters.get(c);

            if (count == 0) {
                return c;
            }

            characters.put(c, count - 1);
        }

        return Character.MIN_VALUE;
    }

    /**
     * Store sum of all characters for both the strings in two variables.
     * Return the difference
     */
    private char findTheDifferenceAsciiSum(String s, String t) {
        int sumS = 0;
        int sumT = 0;

        for (char c: s.toCharArray()) {
            sumS += c;
        }

        for (char c: t.toCharArray()) {
            sumT += c;
        }

        return (char) (sumT-sumS);
    }

    /**
     * XOR of a character (int) with itself is always 0,
     * XOR all characters, return the result
     */
    private char findTheDifferenceXor(String s, String t) {
        int XOR = 0;

        for (char c: s.toCharArray()) {
            XOR = XOR ^ c;
        }

        for (char c: t.toCharArray()) {
            XOR = XOR ^ c;
        }

        return (char) XOR;
    }

}

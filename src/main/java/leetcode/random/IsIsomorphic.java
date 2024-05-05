package leetcode.random;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 205: Isomorphic Strings

 * Given two strings s and t, determine if they are isomorphic.

 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same character,
 * but a character may map to itself.

 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true

 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false

 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true

 * Constraints:
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 *
 * @author rathi.prakhar@outlook.com
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("badc", "baba"));
    }
    public boolean isIsomorphic(String s, String t) {
        char[] mappings = new char[256];
        Set<Character> mapped = new HashSet<>();

        for (int index = 0; index < s.length(); index++) {
            char sChar = s.charAt(index);
            char tChar = t.charAt(index);

            if (mappings[sChar] == Character.MIN_VALUE && !mapped.contains(tChar)) {
                mappings[sChar] = tChar;
                mapped.add(tChar);
            }

            if (mappings[sChar] != Character.MIN_VALUE && mappings[sChar] != tChar) {
                return false;
            }

            if (mappings[sChar] == Character.MIN_VALUE && mapped.contains(tChar)) {
                return false;
            }
        }

        return true;
    }
}

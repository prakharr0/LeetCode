package leetcode.random;

/**
 * LeetCode 1160
 * <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/">Link</a>
 *
 * @author rathi.prakhar@outlook.com
 */
public class CountCharacters {

    /**
     * Store the count of characters in chars in an array, ex: count

     * iterate through each word:
     *      store count of each character in countWord array
     *      if (countWord[c] > count[c]) --> word is invalid, appears more times than allowed
     *      sum lengths of all valid words
     */
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[256];

        for (char c: chars.toCharArray()) {
            count[c]++;
        }

        int maxLen = 0;

        for (String word: words) {
            int[] countWord = new int[256];

            boolean valid = true;

            for (char c: word.toCharArray()) {
                countWord[c]++;

                if (countWord[c] > count[c]) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                maxLen += word.length();
        }

        return maxLen;
    }
}

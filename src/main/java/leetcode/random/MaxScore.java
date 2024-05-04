package leetcode.random;

/**
 * LeetCode 1422

 * Given a string s of zeros and ones, return the maximum score after splitting the string into
 * two non-empty substrings (i.e. left substring and right substring).

 * The score after splitting a string is the number of zeros in the left substring plus the number
 * of ones in the right substring.

 * Example 1:
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3

 * @author rathi.prakhar@outlook.com
 */
public class MaxScore {

    /**
     * We always start with a left and a right substring (0, 1) and (1, n) respectively.
     * Count the number of 0s in the left and 1s in the right here.
     * When moving right, we include one character from right into left substring.
     * If that character is '0' ==> count of 0s in the left increases by 1
     * Otherwise, count of 1s in the right decreases by 1

     * Use the logic until i < n - 1, because the substrings are non-empty, the split stops
     * when right substring contains only the last character
     */
    public int maxScore(String s) {
        if (s == null || s.isEmpty()) return 0;

        int countLeftZero = 0;
        int countRightOne = 0;

        // First left and right substrings
        String left = s.substring(0, 1);
        String right = s.substring(1);

        // count 0s in left
        for (char c: left.toCharArray()) {
            if (c == '0') countLeftZero++;
        }

        // count 1s in right
        for (char c: right.toCharArray()) {
            if (c == '1') countRightOne++;
        }

        int maxScore = countRightOne + countLeftZero;

        int index = 1;

        while (index < s.length()-1) {

            if (s.charAt(index) == '0') {
                countLeftZero++;
            } else {
                countRightOne--;
            }

            maxScore = Math.max(maxScore, countRightOne + countLeftZero);

            index++;
        }

        return maxScore;
    }

    /**
     *  score = Zero_Left + One_Total - One_Left;
     *  find total ones in the beginning.

     *  iterate from i = 1 to n - 1.

     */
    public int maxScoreAnother(String s) {
        if (s == null || s.length() < 2) return 0;

        int oneTotal = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') oneTotal++;
        }

        int zeroLeft = (s.charAt(0) == '0') ? 1 : 0;
        int oneLeft = 1 - zeroLeft;

        int maxScore = zeroLeft + oneTotal - oneLeft;
        int index = 1;

        while (index < s.length()-1 ) {
            if (s.charAt(index) == '0') {
                zeroLeft++;
            } else {
                oneLeft++;
            }

            maxScore = Math.max(maxScore, zeroLeft + oneTotal - oneLeft);

            index++;
        }

        return maxScore;

    }
}

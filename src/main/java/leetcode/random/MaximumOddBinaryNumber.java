package leetcode.random;

/**
 * LeetCode 2864: Maximum Odd Binary Number

 * You are given a binary string s that contains at least one '1'.
 * You have to rearrange the bits in such a way that the resulting binary number is the maximum
 * odd binary number that can be created from this combination.
 * Return a string representing the maximum odd binary number that can be created from the given combination.

 * Note that the resulting string can have leading zeros.

 * Example 1:
 * Input: s = "010"
 * Output: "001"
 * Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".

 * Example 2:
 * Input: s = "0101"
 * Output: "1001"
 * Explanation: One of the '1's must be in the last position. The maximum number
 * that can be made with the remaining digits is "100". So the answer is "1001".

 * Constraints:
 * 1 <= s.length <= 100
 * s consists only of '0' and '1'.
 * s contains at least one '1'.

 * @author rathi.prakhar@outlook.com
 */
public class MaximumOddBinaryNumber {
    /**
     * If only 1 '1' exits ==> must be at the least significant bit
     * Otherwise, if n > 1. Then one '1' is at the least significant bit, others in the beginning most significant bits
     */
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') countOnes++;
        }

        int n = s.length();

        if (countOnes == 1) {
            int oneIndex = s.indexOf('1');
            if (oneIndex == n-1) return s;

            return s.substring(0, oneIndex) + '0' + s.substring(oneIndex + 1, n-1) + '1';
        }

        StringBuilder result = new StringBuilder();

        int index = 0;

        while (index < countOnes - 1) {
            result.append('1');
            index++;
        }

        while(index < n-1) {
            result.append('0');
            index++;
        }

        result.append('1');

        return result.toString();
    }
}

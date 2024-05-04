package leetcode.random;

/**
 * LeetCode 1758: Minimum changes to make alternating binary string

 * You are given a string s consisting only of the characters '0' and '1'. In one operation,
 * you can change any '0' to '1' or vice versa.

 * The string is called alternating if no two adjacent characters are equal. For example,
 * the string "010" is alternating, while the string "0100" is not.

 * Return the minimum number of operations needed to make s alternating.
 *
 * @author rathi.prakhar@outlook.com
 */
public class MinOpertionsBinaryString {

    /**
     * For any given length n, there are only two possibilities: starting with 0 or 1.

     * For example if n = 7.
     * Option 1 : 0101010 ; Option 2: 1010101

     * if input string is 1001001. Compare with both the options to find mismatches at every index.
     * Then find the minimum number of mismatches in both approaches.

     * We further observe that when a string starts with 0, every even index has 0 and odd index has 1.
     * Also, for a 1-starting string, every odd index has 0 and even index has 1.

     * Using this observation, we do not need to compare with strings. Instead, we can compare if there is a
     * mismatch at odd/even indices in both cases.

     * O(n) --> traversing once.
     */
    public int minOperations(String s) {
        if (s == null || s.length() < 2) return 0;

        int startWithZero = 0;
        int startWithOne = 0;

        for (int i = 0; i < s.length(); i++) {
            // if the string starts with 0
            // 1 must be at odd positions and 0 at even
            // if not, then one replacement needed
            if (i % 2 == 0 && s.charAt(i) == '1') startWithZero++;
            if (i % 2 != 0 && s.charAt(i) == '0') startWithZero++;


            // if the string starts with 1
            // 0 must be at odd positions and 1 at even
            // if not, then one replacement needed
            if (i % 2 == 0 && s.charAt(i) == '0') startWithOne++;
            if (i % 2 != 0 && s.charAt(i) == '1') startWithOne++;
        }

        return Math.min(startWithZero, startWithOne);

    }
}

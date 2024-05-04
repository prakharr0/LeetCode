package leetcode.random;

/**
 * LeetCode 1903: Largest odd number in a string
 * You are given a string num, representing a large integer.
 * Return the largest-valued odd integer (as a string) that is a
 * non-empty substring of num, or an empty string "" if no odd integer exists.

 * Input: num = "35427"
 * Output: "35427"

 * Input: num = "52"
 * Output: "5"

 * Input: num = "4206"
 * Output: ""
 *
 * @author rathi.prakhar@outlook.com
 */
public class LargestOddNumber {
    public String largestOddNumber(String num) {
        if (num == null || num.isEmpty()) return "";

        String result = "";

        int index = num.length() - 1;

        while (index >= 0) {
            int current = num.charAt(index) - '0';
            if (current % 2 != 0) {
                result = num.substring(0, index + 1);
                break;
            }

            index--;
        }

        return result;
    }
}

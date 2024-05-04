package leetcode.random;

/**
 * LeetCode 2264: Largest 3-Same-Digit Number in String
 * <a href = https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/>Link</a>

 * @author rathi.prakhar@outlook.com

 * You are given a string num representing a large integer.
 * An integer is good if it meets the following conditions:

 * It is a substring of num with length 3.
 * It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string ""
 * if no such integer exists.

 * Note:
 * A substring is a contiguous sequence of characters within a string.
 * There may be leading zeroes in num or a good integer.
 *
 */
public class I_LargestGoodInteger {


    /**
     * Compare the last two indices
     */
    public String largestGoodInteger(String num) {
        if (num == null || num.length() < 3) return "";

        String result = "";
        int index = 2;

        while (index < num.length()) {
            if (num.charAt(index) == num.charAt(index-1) &&
                    num.charAt(index) == num.charAt(index-2) &&
                    num.substring(index-2, index+1).compareTo(result) > 0) {
                result = num.substring(index-2, index+1);
            }

            index++;
        }

        return result;
    }

    /**
     * Use Sliding Window Protocol.

     * start = 0, end = 0. If charAt(end+1) == charAt(end) ==> count is count + 1.
     * Else, start = end + 1, end = end + 1, count = 1 (the char at end+1)

     * If count == 3, store maxNum in a variable, and compare this num with the max.
     */
    public String largestGoodIntegerSlidingWindow(String num) {
        if (num == null || num.length() < 3) return "";

        int start = 0;
        int end = 0;

        int maxNum = Integer.MIN_VALUE;
        int len = num.length();

        int count = 1;
        String result = "";

        while (end < len-1) {
            if (num.charAt(end + 1) == num.charAt(end)) {
                count++;

                if (count == 3) {
                    char newChar = num.charAt(end);
                    int currentNum = Integer.parseInt(String.valueOf(newChar));

                    if (currentNum > maxNum) {
                        result = num.substring(start, end + 2);
                        maxNum = currentNum;
                    }
                }
            } else {
                start = end + 1;
                count = 1;
            }

            end++;
        }

        return result;
    }
}

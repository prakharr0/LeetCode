package leetcode.random;

import java.util.Set;
import java.util.HashSet;

/**
 * LeetCode 2441: Largest positive Integer that exists with its negative

 * Given an integer array nums that does not contain any zeros, find the
 * largest positive integer k such that -k also exists in the array.
 * Return the positive integer k. If there is no such integer, return -1.

 * Example 1:
 * Input: nums = [-1,2,-3,3]
 * Output: 3
 * Explanation: 3 is the only valid k we can find in the array.

 * Example 2:
 * Input: nums = [-1,10,6,7,-7,1]
 * Output: 7
 * Explanation: Both 1 and 7 have their corresponding negative values in
 * the array. 7 has a larger value.

 * Example 3:
 * Input: nums = [-10,8,6,7,-2,-3]
 * Output: -1
 * Explanation: There is no a single valid k, we return -1.

 * @author rathi.prakhar@outlook.com
 */
public class FindMaxPositiveWithNegativeCounterpart {

    /**
     * Maintain a set of nums found so far until the ith index.
     * If negative found, add the abs to the result

     * OR Use a 2001 size array.
     * Add 1000 to every number, and set that index to 1 when found
     */
    public int findMaxK(int[] numbers) {
        Set<Integer> nums = new HashSet<>();
        int maxNum = Integer.MIN_VALUE;

        for (int num: numbers) {
            if (nums.contains(0 - num)) {
                int abs = Math.abs(num);
                maxNum = Math.max(maxNum, abs);
            }

            nums.add(num);
        }

        return (maxNum == Integer.MIN_VALUE) ? -1 : maxNum;
    }
}

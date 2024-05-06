package dp;

import java.util.*;

/**
 * LeetCode 413 : Arithmetic Slices

 * An integer array is called arithmetic if it consists of at least
 * three elements and if the difference between any two consecutive
 * elements is the same.

 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.

 * A subarray is a contiguous subsequence of the array.

 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

 * Example 2:
 * Input: nums = [1]
 * Output: 0

 * Constraints:
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000

 * @author rathi.prakhar@outlook.com
 */
public class I_ArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(new I_ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }

    /**
     * At each index, I have a choice to either include the element or ignore it
     * If the list on included elements is non-empty, I cannot ignore the current
     * element --> violates contiguous subarray definition

     * At each step, find the current difference and compare it with the prev difference
     * if they are same :
     *  1. length of list > 2 --> valid answer
     *  2. Continue
     * else do not take the current element

     * At the end, sum all possibilites and return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        return solve(nums, 0, new ArrayList<Integer>(), Integer.MIN_VALUE);
    }

    private int solve(int[] nums, int index, List<Integer> list, int diff) {

        if (index >= nums.length) return 0;

        // Take
        int take = 0;
        list.add(nums[index]);
        int currentDiff = Integer.MIN_VALUE;

        if (list.size() > 1) {
            int lastIndex = list.size() - 1;
            currentDiff = list.get(lastIndex - 1) - list.get(lastIndex);
        }

        if (diff == Integer.MIN_VALUE) diff = currentDiff;

        if (currentDiff == diff) {
            take = solve(nums, index + 1, list, currentDiff);
            if (list.size() > 2) take++;
        }

        list.remove(Integer.valueOf(nums[index]));

        // Not Take
        int notTake = 0;

        if (list.isEmpty()){
            notTake = solve(nums, index + 1, list, diff);
        }

        return take + notTake;
    }
}

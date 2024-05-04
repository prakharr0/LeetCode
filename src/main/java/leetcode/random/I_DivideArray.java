package leetcode.random;

import java.util.Arrays;

/**
 * LeetCode 2966: Divide array into arrays with maximum difference

 * You are given an integer array nums of size n and a positive integer k.
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 *      Each element of nums should be in exactly one array.
 *      The difference between any two elements in one array is less than or equal to k.

 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions,
 * return an empty array. And if there are multiple answers, return any of them.

 * Example 1:
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.

 * Example 2:
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.

 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * n is a multiple of 3.
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105

 * @author rathi.prakhar@outlook.com
 */
public class I_DivideArray {

    /**
     * First sort the array. start at i = 2 with increments i = i + 3 in the for loop
     * all the pairs [i,i-1,i-2] must satisfy the difference <= k.

     * if not possible, return empty array
     */
    public int[][] divideArray(int[] nums, int k) {
        if (nums == null || nums.length < 1) return new int[][]{};

        int n = nums.length;
        if (n % 3 != 0) return new int[][]{};

        Arrays.sort(nums);

        int[][] result = new int[n/3][3];
        int index = 0;

        for (int i = 2; i < n ; i = i+3) {
            int current = nums[i];
            int prev = nums[i-1];
            int prePrev = nums[i-2];

            if (current - prev <= k && prev - prePrev <= k && current-prePrev <= k) {
                int[] interm = new int[]{prePrev, prev, current};
                result[index++] = interm;
            } else {
                return new int[][]{};
            }
        }

        return result;
    }
}

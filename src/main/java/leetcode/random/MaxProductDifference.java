package leetcode.random;

/**
 * LeetCode 1913: Maximum Product Difference between Two Pairs

 * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
 * Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

 * Return the maximum such product difference.

 * Example 1:
 * Input: nums = [5,6,2,7,4]
 * Output: 34
 * Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
 * The product difference is (6 * 7) - (2 * 4) = 34.

 * Example 2:
 * Input: nums = [4,2,5,9,7,4,8]
 * Output: 64
 * Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
 * The product difference is (9 * 8) - (2 * 4) = 64.
 *
 * @author rathi.prakhar@outlook.com
 */
public class MaxProductDifference {

    /**
     * If sorted ==> first two and last two. But O(n*log n)

     * Keep a track of max1, max2 and min1, min2 for every index
     * O(n)
     */
    public int maxProductDifference(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int index = 0;

        while (index < nums.length) {

            int current = nums[index];

            // MAX comparison
            if (current > max1) {
                max2 = max1;
                max1 = current;
            } else if (current > max2) {
                max2 = current;
            }

            // MIN comparison
            if (current < min1) {
                min2 = min1;
                min1 = current;
            } else if (current < min2) {
                min2 = current;
            }

            index++;
        }

        return (max2 * max1) - (min2 * min1);
    }
}

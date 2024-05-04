package leetcode.random;

/**
 * LeetCode 1164: Max product of two elements in an array

 * All nums[i] > 0

 * Given the array of integers nums, you will choose two different indices i
 * and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

 * @author rathi.prakhar@outlook.com
 */
public class MaxProduct {

    /**
     * Find two largest numbers in the array
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return (nums[0] - 1) * (nums[0] - 1 );
        if (nums.length == 2) return (nums[0] - 1) * (nums[1] - 1 );

        int max1 = 0;
        int max2 = -1;

        for (int num: nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}

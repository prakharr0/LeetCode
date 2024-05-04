package leetcode.random;

/**
 * LeetCode 977: Squares of a Sorted Array

 * Given an integer array nums sorted in non-decreasing order, return an array of
 * the squares of each number sorted in non-decreasing order.

 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].

 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]

 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.

 * @author rathi.prakhar@outlook.com
 */
public class SortedSquares {

    /**
     * Use a two pointer approach to keep track of the elements on the left and right ends respectively.

     * Since the elements can be sorted, a negative number appears towards the left of a positive number.
     * However, the square of a negative number can be larger than a positive number.

     * Therefore, start from 0 and n-1 indices, fill the result array based on the largest squared value.
     */
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) return new int[]{nums[0] * nums[0]};

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }

        return result;
    }
}

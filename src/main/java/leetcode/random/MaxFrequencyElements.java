package leetcode.random;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3005: Count Elements with Maximum Frequency

 * You are given an array nums consisting of positive integers.

 * Return the total frequencies of elements in nums such that those
 * elements all have the maximum frequency.

 * The frequency of an element is the number of occurrences of that
 * element in the array.

 * Example 1:
 * Input: nums = [1,2,2,3,1,4]
 * Output: 4
 * Explanation: The elements 1 and 2 have a frequency of 2 which is the
 * maximum frequency in the array.
 * So the number of elements in the array with maximum frequency is 4.

 * Example 2:
 * Input: nums = [1,2,3,4,5]
 * Output: 5
 * Explanation: All elements of the array have a frequency of 1 which is the maximum.
 * So the number of elements in the array with maximum frequency is 5.

 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100

 * @author rathi.prakhar@outlook.com
 */
public class MaxFrequencyElements {

    /**
     * Store the count of each element in a hashmap and find the maxCount;

     * Iterate over the map and find how many numbers have the maxCount;

     * Can use array since only 100 elements are to be stored

     * To do this in one pass, store the maxCount and the count
     * of numbers with maxCount in a map.

     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        int maxCount = Integer.MIN_VALUE;

        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);

            maxCount = Math.max(maxCount, count.get(num));
        }

        int numbers = 0;

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() == maxCount) numbers++;
        }

        return numbers * maxCount;
    }

}

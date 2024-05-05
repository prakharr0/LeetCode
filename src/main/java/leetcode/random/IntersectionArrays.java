package leetcode.random;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 349: Intersection of Two Arrays

 * Given two integer arrays nums1 and nums2, return an array of their intersection
 * Each element in the result must be unique and you may return the result in any
 * order.

 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]

 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.

 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * @author rathi.prakhar@outlook.com
 */
public class IntersectionArrays {

    /**
     * If linearly searching every element of nums1 in nums2, we take O(mn) time.
     * If we refine the search to be in O(1), the complexity can be reduced to O(m)
     * We use a set, store all elements of nums1 in the set --> O(n)
     * Therefore, total complexity is O(m+n)

     * Reduce space complexity by:
     * 1. Removing objects in nums which have been found common.
     * 2. Store the elements of the smaller array in the set.

     * Another approach:
     * Sort the smaller array --> O(n * log n)
     * Search if every element of the larger array present in the sorted array
     * using binary search

     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();

        for (int num: nums1) {
            nums.add(num);
        }

        Set<Integer> result = new HashSet<>();

        for (int num: nums2) {
            if (nums.contains(num)) result.add(num);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

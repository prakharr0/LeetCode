package leetcode.random;

import java.util.*;

/**
 * LeetCode 78: Find subsets
 *
 * @author rathi.prakhar@outlook.com
 */
public class I_Subsets {

    public static void main(String[] args) {
        System.out.println(new I_Subsets().subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        /**
         * If duplicates
        Set<List<Integer>> result = new TreeSet<>((l1, l2) -> {
            Collections.sort(l1);
            Collections.sort(l2);

            return l1.toString().compareTo(l2.toString());
        });
         */
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        subsets(nums, 0, temp, result);

        return result;
    }

    private void subsets(int [] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index > nums.length-1) {
            result.add(new ArrayList<>(temp));
            return;
        }

        int num = nums[index];

        temp.add(num);
        subsets(nums, index+1, temp, result);

        temp.remove(Integer.valueOf(num));
        subsets(nums, index+1, temp, result);
    }
}

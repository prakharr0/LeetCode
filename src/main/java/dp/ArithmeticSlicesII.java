package dp;

import java.util.*;

/**
 * LeetCode 446 :Arithmetic Slices II

 * Not the best solution, but still good

 * @author rathi.prakhar@outlook.com
 */

public class ArithmeticSlicesII {

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlicesII().numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        return solve(nums, 0, new ArrayList<>(), Long.MIN_VALUE);
    }

    private int solve(int[] nums, int index, List<Integer> list, long diff) {
        if (index >= nums.length) return 0;

        // Take
        int take = 0;
        long currentDiff = Long.MIN_VALUE;
        list.add(nums[index]);

        if (list.size() > 1) {
            int last = list.size() - 1;
            currentDiff = (long) list.get(last - 1) - list.get(last);
        }

        if (diff == Long.MIN_VALUE || diff == currentDiff) {
            take = solve(nums, index + 1, list, currentDiff);
            if (list.size() > 2) take++;
        }

        list.remove(Integer.valueOf(nums[index]));

        // Not Take
        int notTake = solve(nums, index + 1, list, diff);

        return take + notTake;
    }
}

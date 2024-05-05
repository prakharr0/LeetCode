package leetcode.random;

import java.util.*;

/**
 * LeetCode 46: find permutations
 */
public class I_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        /**
         * If nums contains duplicates, use a set like
         * {@link I_Subsets}
         */

        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        permute(nums, visited, temp, result);

        return result;
    }

    private void permute(int [] nums, boolean [] visited, List<Integer> temp, List<List<Integer>> result) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                permute(nums, visited, temp, result);
                temp.remove(Integer.valueOf(nums[i]));
                visited[i] = false;
            }
        }
    }

    private List<List<Integer>> permuteDuplicates(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        permuteDuplicates(count, result, temp, nums.length);

        return result;
    }

    private void permuteDuplicates(Map<Integer, Integer> count,
                                   List<List<Integer>> result,
                                   List<Integer> temp,
                                   int n) {

        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() > 0) {
                temp.add(entry.getKey());
                count.put(entry.getKey(), entry.getValue() - 1);
                permuteDuplicates(count, result, temp, n);
                count.put(entry.getKey(), entry.getValue() + 1);
                temp.remove(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        new I_Permutations().permuteDuplicates(new int[]{1,1,2});
    }
}

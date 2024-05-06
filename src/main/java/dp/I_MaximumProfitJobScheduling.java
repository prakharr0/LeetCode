package dp;

import java.util.*;

/**
 * LeetCode 1235: Maximum Profit in Job Scheduling

 * We have n jobs, where every job is scheduled to be done from startTime[i] to
 * endTime[i], obtaining a profit of profit[i].

 * You're given the startTime, endTime and profit arrays, return the maximum
 * profit you can take such that there are no two jobs in the subset with
 * overlapping time range.

 * If you choose a job that ends at time X you will be able to start another
 * job that starts at time X.
 *
 * @author rathi.prakhar@outlook.com
 */
public class I_MaximumProfitJobScheduling {

    public static void main(String[] args) {
        System.out.println(jobScheduling(
                new int[]{1,2,3,3},
                new int[]{3,4,5,6},
                new int[]{50,10,40,70}
        ));
    }

    /**
     * sort based on start time
     * At each index: two choices, either take it or ignore
     */
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // mapping the start time to profit
        int[][] array = new int[startTime.length][3];
        // index changes ==> memoize around it
        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < startTime.length; i++) {
            array[i][0] = startTime[i];
            array[i][1] = endTime[i];
            array[i][2] = profit[i];
        }

        Arrays.sort(array, (a, b) -> a[0] - b[0]);

        return scheduleRight(array, 0, dp);
    }

    private static int scheduleRight(int[][] arr, int index, Map<Integer, Integer> dp) {
        if (index > arr.length - 1 || index < 0) return 0;

        if (dp.containsKey(index)) return dp.get(index);

        // Take index ele
        int next = binarySearchNextIndex(arr, index, arr[index][1]);
        int taken = arr[index][2] + scheduleRight(arr, next, dp);

        // Ignore index ele
        int notTaken = scheduleRight(arr, index + 1, dp);

        dp.put(index, Math.max(taken, notTaken));
        return Math.max(taken, notTaken);
    }

    private static int binarySearchNextIndex(int[][] arr, int start, int target) {
        int left = start;
        int right = arr.length-1;

        int result = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (arr[mid][0] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

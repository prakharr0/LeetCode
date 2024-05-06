package dp;

/**
 * LeetCode 1335: Minimum difficulty of a job schedule

 * You want to schedule a list of jobs in d days. Jobs are dependent
 * (i.e To work on the ith job, you have to finish all the jobs j where
 * 0 <= j < i).

 * You have to finish at least one task every day. The difficulty of a
 * job schedule is the sum of difficulties of each day of the d days.
 * The difficulty of a day is the maximum difficulty of a job done on that day.

 * You are given an integer array jobDifficulty and an integer d.
 * The difficulty of the ith job is jobDifficulty[i].

 * Return the minimum difficulty of a job schedule. If you cannot
 * find a schedule for the jobs return -1.

 * @author rathi.prakhar@outlook.com
 */
public class I_MinimumJobDifficulty {

    public static void main(String[] args) {
        System.out.println(new I_MinimumJobDifficulty().minDifficulty(new int[]{6,5,4,3,2,1}, 2));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        return minDifficulty(jobDifficulty, d, 0);
    }

    /**
     * If there are more days than tasks, return -1

     * if There is only one day, find the max of that day

     * Otherwise, we can choose [0], [0,1]... tasks leaving at least d - 1 for the
     * remaining d-1 days.

     * At root, find max of each day, add them, and then return the minimum of all
     * such combinations
     */
    private int minDifficulty(int [] diff, int days, int start) {
        if (diff.length < days) return -1;
        if (days == 1) {
            int max = diff[start];

            for (int i = start; i < diff.length; i++) {
                max = Math.max(max, diff[i]);
            }

            return max;
        }

        int maxDiff = diff[start];
        int finalRes = Integer.MAX_VALUE;

        for (int i = start; i <= diff.length - days; i++) {
            maxDiff = Math.max(maxDiff, diff[i]);
            int result = maxDiff + minDifficulty(diff, days-1, i+1);

            finalRes = Math.min(finalRes, result);
        }

        return finalRes;
    }}

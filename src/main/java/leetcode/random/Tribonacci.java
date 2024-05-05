package leetcode.random;

/**
 * LeetCode 1137: N-th Tribonacci Number

 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 *
 * @author rathi.prakhar@outlook.com
 */
public class Tribonacci {

    /**
     * Solved using dynamic programming.
     * Each cell i belonging to [3, infinity) can be calculated based on the
     * above-mentioned recurrence relation.

     * Maintain a table and fill it in.
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;

        int[] trib = new int[n+1];
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;

        for (int i = 3; i <= n; i++) {
            trib[i] = trib[i-1] + trib[i-2] + trib[i-3];
        }

        return trib[n];
    }
}

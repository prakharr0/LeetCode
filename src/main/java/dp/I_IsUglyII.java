package dp;

/**
 * LeetCode 264: Ugly Number II

 * Find the nth ugly number

 * @author rathi.prakhar@outlook.com
 */
public class I_IsUglyII {

    /**
     * Maintain an array, ith ugly number = result[i];

     * let i2 always multiply by 2, i3 by 3, and i5 by 5.
     * Initially, all the three point to 1.

     * multiply the i2th ugly number by 2, i3th by 3, and i5th by 5.
     * Get the minimum, and increase pointer by 1 of the corresponding multiplier
     *
     */
    public int nthUglyNumber(int n) {
        // ith ugly number = result[i]
        int[] result = new int[n+1];

        result[0] = 0;
        result[1] = 1;

        int i2 = 1;
        int i3 = 1;
        int i5 = 1;

        for (int i = 2; i <= n; i++) {
            int i2Ugly = result[i2] * 2;
            int i3Ugly = result[i3] * 3;
            int i5Ugly = result[i5] * 5;

            int min = Math.min(i2Ugly, i3Ugly);
            min = Math.min(min, i5Ugly);

            result[i] = min;

            if (min == i2Ugly) i2++;
            if (min == i3Ugly) i3++;
            if (min == i5Ugly) i5++;
        }

        return result[n];
    }
}

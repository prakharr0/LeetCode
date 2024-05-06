package dp;

/**
 * LeetCode 263: Ugly number

 * An ugly number is a positive integer whose prime factors are
 * limited to 2, 3, and 5.

 * Given an integer n, return true if n is an ugly number.

 * @author rathi.prakhar@outlook.com
 */
public class I_IsUgly {

    /**
     * find the prime factors.
     */
    public boolean isUgly(int n) {
        if (n < 1) return false;
        if (n < 7) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i != 2 && i != 3 && i != 5) return false;

                return isUgly(n/i);
            }
        }

        return false;
    }
}

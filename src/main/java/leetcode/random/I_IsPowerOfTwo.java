package leetcode.random;

/**
 * LeetCode 231: Power of Two

 * return if a number if power of two

 * @author rathi.prakhar@outlook.com
 */
public class I_IsPowerOfTwo {

    /**
     * AND of n and n-1, when n is a power of 2, is 0.

     * Ex: 8 == 1000, 7 == 0111. All bits set in 8 are unset in 7, and vice versa.
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;

        return (n & n-1) == 0;
    }

}

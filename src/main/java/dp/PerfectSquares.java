package dp;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        return numSquares(n, dp);
    }

    public static int numSquares(int n, Integer[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (dp[n] != null) return dp[n];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int remaining = n - (i*i);
            int result = numSquares(remaining, dp);

            if (result >= 0) min = Math.min(min, result + 1);
        }

        dp[n] = min;
        return min;
    }

}

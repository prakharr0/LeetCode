package dp;

/**
 * LeetCode 931 Minimum Falling Path Sum

 * Given an n x n array of integers matrix, return the minimum sum of
 * any falling path through matrix.
 * A falling path starts at any element in the first row and chooses
 * the element in the next row that is either directly
 * below or diagonally left/right. Specifically, the next element from
 * position (row, col) will be (row + 1, col - 1), (row + 1, col), or
 * (row + 1, col + 1).

 * @author rathi.prakhar@outlook.com
 */
public class MinFallingPathSum {

    /**
     * Same choices at every step --> DP
     */
    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;
        int row = 0;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            int sum = solve(row, col, matrix, dp);
            min = Math.min(sum, min);
        }

        return min;
    }

    private int solve(int row, int col, int[][] matrix, Integer[][] dp) {
        if (row >= matrix.length || row < 0) return -200;
        if (col >= matrix[0].length || col < 0) return -200;

        if (dp[row][col] != null) return dp[row][col];

        int sum = matrix[row][col];

        int localMin = Integer.MAX_VALUE;

        // BELOW
        int below = solve(row + 1, col, matrix, dp);
        if (below != -200) {
            localMin = Math.min(below, localMin);
        }

        // DIAGONAL LEFT
        int diagLeft = solve(row + 1, col-1, matrix, dp);
        if (diagLeft != -200) {
            localMin = Math.min(diagLeft, localMin);
        }

        // DIAGONAL RIGHT
        int diagRight = solve(row + 1, col + 1, matrix, dp);
        if (diagRight != -200) {
            localMin = Math.min(diagRight, localMin);
        }

        dp[row][col] = (localMin == Integer.MAX_VALUE) ? sum : sum + localMin;
        return dp[row][col];
    }
}

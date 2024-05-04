package leetcode.random;

/**
 * LeetCode 1582: Special positions in a binary matrix

 * Given an m x n binary matrix mat, return the number of special positions in mat.

 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i
 * and column j are 0 (rows and columns are 0-indexed).

 * @author rathi.prakhar@outlook.com
 */
public class NumSpecialMatrix {

    /**
     * For every mat[i][j] == 1, there must be exactly one cell in the row i and the column j set to 1.
     * Therefore, the count of 1s in the row i and column j must be 1 respectively.

     * Maintain two arrays, countRows and countCols to count the frequency of 1s.
     * Iterate over the mn elements to fill these arrays.

     * Reiterate over the mn elements but, if (mat[i][j] == 1 and countRows == 1 and countCols == 1) then,
     * the only 1 in that row and column is in the cell mat[i][j] ==> it is a good column.

     */
    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length < 1) return 0;

        int[] countRows = new int[mat.length];
        int[] countCols = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    countRows[i]++;
                    countCols[j]++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && countRows[i] == 1 && countCols[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}

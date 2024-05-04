package leetcode.random;

/**
 * LeetCode 867: Transpose Matrix

 * @author rathi.prakhar@outlook.com
 */
public class MatrixTranspose {

    /**
     * Square matrices --> in place swaps
     * Others --> new array of dimension col x row to be filled
     */
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length < 1) return new int[][]{};

        if (matrix[0].length == matrix.length) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            return matrix;
        }

        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}

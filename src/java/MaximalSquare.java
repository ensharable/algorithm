package java;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 * @author Marcus
 *
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] res = new int[row][col];

		int max = Integer.MIN_VALUE; // this is the max length of the square,
										// not the area. maxArea = max*max;
		// for the top of the matrix, possible the island only on the top row
		for (int i = 0; i < col; i++) {
			res[0][i] = matrix[0][i] - '0';
			max = Math.max(max, res[0][i]);
		}
		// for the left most of the matrix, possible the island only on the left
		// column
		for (int i = 1; i < row; i++) {
			res[i][0] = matrix[i][0] - '0';
			max = Math.max(max, res[i][0]);
		}

		// for the rest
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == '1') {
					res[i][j] = Math.min(res[i - 1][j - 1], Math.min(res[i][j - 1], res[i - 1][j])) + 1;
					max = Math.max(max, res[i][j]);
				}
			}
		}
		return max * max; // maxArea = max*max;
	}
}

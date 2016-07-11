package java;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 *
 *Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

 * 
 */
public class NumberofIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int counter = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '1') {
					counter++;
					dfs(grid, row, col); // mark visited to 2
				}
			}
		}
		return counter;
	}

	private void dfs(char[][] grid, int row, int col) {
		if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1') {
			grid[row][col] = '2';
			dfs(grid, row - 1, col);// left
			dfs(grid, row, col - 1);// down
			dfs(grid, row + 1, col);// up
			dfs(grid, row, col + 1);// right
		}
	}
}

package solutions.pack7_Recursion;

public class GridPaths_661090 {

    public static int numberOfPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Edge case: If the starting or ending cell has an obstacle, there are no paths
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        // Initialize the DP table
        int[][] dp = new int[rows][cols];

        // Base case: There is 1 way to reach the starting cell if it's not an obstacle
        dp[0][0] = 1;

        // Fill in the number of ways to reach each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // No paths through obstacles
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j]; // Paths from the cell above
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1]; // Paths from the cell to the left
                    }
                }
            }
        }

        // The value in the bottom-right cell is the number of unique paths
        return dp[rows - 1][cols - 1];
    }
}

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int totalZero = 0;
        int startX = 0;
        int startY = 0;

        // 1. Pre-process: Find start and count zeros
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    totalZero++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        return dfs(grid, startX, startY, totalZero, 0);
    }

    public int dfs(int[][] grid, int i, int j, int totalZeros, int currentZeros) {
        // Base Case: Boundaries and Obstacles
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return 0;
        }

        // Base Case: Target Found
        if (grid[i][j] == 2) {
            // Check if we visited all non-obstacle squares
            return (totalZeros == currentZeros - 1) ? 1 : 0;
        }

        // Mark current cell as visited (acting as a temporary obstacle)
        grid[i][j] = -1;

        // Explore all 4 directions
        int totalPaths = dfs(grid, i + 1, j, totalZeros, currentZeros + 1) + // Down
                         dfs(grid, i - 1, j, totalZeros, currentZeros + 1) + // Up
                         dfs(grid, i, j + 1, totalZeros, currentZeros + 1) + // Right
                         dfs(grid, i, j - 1, totalZeros, currentZeros + 1);  // Left

        // Backtrack: Unmark the cell so it can be used in other paths
        grid[i][j] = 0;

        return totalPaths;
    }
}
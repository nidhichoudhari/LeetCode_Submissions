class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m+1][n+1];
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));

        return helper(grid, m, n, 0, 0);
    }

    private int helper(int[][] grid, int m, int n, int i, int j) {
        if (i == m-1 && j == n-1) return grid[i][j];
        if (memo[i][j] != -1) return memo[i][j];

        if (i == m-1) {
            memo[i][j] = grid[i][j] + helper(grid, m, n, i, j+1);
        } else if (j == n-1) {
            memo[i][j] = grid[i][j] + helper(grid, m, n, i+1, j);
        } else {
            memo[i][j] = grid[i][j] + Math.min(helper(grid, m, n, i, j+1), helper(grid, m, n, i+1, j));
        }

        return memo[i][j];
    }
}
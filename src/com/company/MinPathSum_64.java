package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MinPathSum_64
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/2 10:44
 */
public class MinPathSum_64 {
    /**
     * 暴力递归，时间超时
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        return process(grid, row, 0, col, 0);
    }


    public int process(int[][] grid, int row, int curRow, int col, int curCol) {
        if (curRow == row - 1 && curCol == col - 1) {
            return grid[curRow][curCol];
        }
        if (curRow == row) {
            return Integer.MAX_VALUE;
        }
        if (curCol == col) {
            return Integer.MAX_VALUE;
        }
        return grid[curRow][curCol] + Math.min(process(grid, row, curRow + 1, col, curCol),
                process(grid, row, curRow, col, curCol + 1));
    }

    /**
     * 简单动规，建立一个备忘录
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = row; i >= 0; i--) {
            for (int j = col; j >= 0; j--) {
                if (i == row && j != col) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != row && j == col) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != row && j != col) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 用原本的数组作为备忘录
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j != n)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == n && i != m)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (j != n && i != m)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }

}

package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName:com.company
 * @ClassName:NumIslands_200
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/4 11:41
 */
public class NumIslands_200 {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    infect(grid, grid.length, i, grid[0].length, j);
                }
            }
        }
        return count;
    }

    public static void infect(char[][] grid, int row, int i, int col, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, row, i + 1, col, j);
        infect(grid, row, i - 1, col, j);
        infect(grid, row, i, col, j + 1);
        infect(grid, row, i, col, j - 1);
    }

    public static void main(String[] args) {
        char[][] matix = {};
    }
}

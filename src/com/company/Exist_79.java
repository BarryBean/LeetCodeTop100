package com.company;

import java.util.Arrays;

/**
 * @PackageName:com.company
 * @ClassName:Exist_79
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/10 11:10
 */
public class Exist_79 {

    public static boolean exist(char[][] board, String word) {
        if (word == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        int[][] memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //先找到第一个匹配，开始后续找
                if (process(board, chars, 0, i, j, row, col, memo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process(char[][] board, char[] chars, int index, int i, int j, int row, int col, int[][] memo) {
        if (index >= chars.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || memo[i][j] != 0 || chars[index] != board[i][j]) {
            return false;
        }

        memo[i][j] = 1;
        boolean result = process(board, chars, index + 1, i - 1, j, row, col, memo) ||
                process(board, chars, index + 1, i + 1, j, row, col, memo) ||
                process(board, chars, index + 1, i, j - 1, row, col, memo) ||
                process(board, chars, index + 1, i, j + 1, row, col, memo);
        memo[i][j] = 0;
        return result;
    }
}

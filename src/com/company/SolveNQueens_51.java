package com.company;

import java.util.*;

/**
 * @PackageName:com.company
 * @ClassName:SolveNQueens_51
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/9 10:49
 */
public class SolveNQueens_51 {
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        //Arrays.fill(chars, '.');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        process(n, 0, chars);
        return ret;
    }

    public void process(int n, int index, char[][] chars) {
        if (index == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(chars[i]));
            }
            ret.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            //皇后就是八个方向的车，即八个方向上都不能有Q
            //这里只要判断index的上半部分的方向
            if (!isVaild(n, chars, index, col)) {
                continue;
            }
            chars[index][col] = 'Q';
            process(n, index + 1, chars);
            chars[index][col] = '.';
        }
    }

    //检查列上，左上，右上，行有没有Q
    public boolean isVaild(int n, char[][] chars, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < col; i++) {
            if (chars[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:GenerateParenthesis_22
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/11 9:37
 */
public class GenerateParenthesis_22 {
    /**
     * 每加一个都判断，失败就回溯
     *
     * @param n
     * @return
     */

    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        process(0, 0, n, new StringBuffer());
        return list;
    }

    public void process(int ln, int rn, int n, StringBuffer str) {
        if (ln > n || rn > n || ln < rn) {
            return;
        }
        if (ln == n && rn == n) {
            list.add(str.toString());
        }

        process(++ln, rn, n, str.append("("));
        str.deleteCharAt(str.lastIndexOf("("));
        ln--;

        process(ln, ++rn, n, str.append(")"));
        str.deleteCharAt(str.lastIndexOf(")"));
        rn--;
    }
}

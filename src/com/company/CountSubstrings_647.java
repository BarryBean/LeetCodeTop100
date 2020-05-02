package com.company;

/**
 * @PackageName:com.company
 * @ClassName:CountSubstrings_647
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/27 10:15
 */
public class CountSubstrings_647 {
    /**
     * O(n^2) 相当于对每个位置都从头开始寻找
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                count += plalindrome(chars, j, i);
            }
        }
        return count;
    }

    private int plalindrome(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private int sum = 0;

    /**
     * 中间向两边拓展
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            helper(chars, i, i);
            helper(chars, i, i + 1);
        }
        return sum;
    }

    private void helper(char[] chars, int start, int end) {
        while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
            start--;
            end++;
            sum++;
        }
    }

}

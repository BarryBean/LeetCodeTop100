package com.company;

import java.util.*;

/**
 * @PackageName:com.company
 * @ClassName:LongestPalindrome_5
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/12 11:32
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = strVaild(s, i, i);
            String s2 = strVaild(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //从中间往外走
    public static String strVaild(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}

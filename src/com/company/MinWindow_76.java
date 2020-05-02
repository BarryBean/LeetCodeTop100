package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:com.company
 * @ClassName:MinWindow_76
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/7 13:52
 */
public class MinWindow_76 {
    /**
     * hashmap方式
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int left = 0, right = 0, match = 0, start = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for (char c : t.toCharArray()) {
            Integer time = needs.getOrDefault(c, 0);
            needs.put(c, time + 1);
        }
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            char c1 = chars[right];
            //当前字符是pattern串中的字符
            if (needs.containsKey(c1)) {
                Integer times = windows.getOrDefault(c1, 0);
                windows.put(c1, times + 1);
                if (windows.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;

            //符合条件，开始缩小窗口
            while (match == needs.size()) {
                int len = right - left;
                if (minLen > len) {
                    start = left;
                    minLen = len;
                }

                char c2 = chars[left];
                if (needs.containsKey(c2)) {
                    Integer tmp = windows.get(c2);
                    tmp--;
                    if (tmp < needs.get(c2)) {
                        match--;
                    }
                    if (tmp == 0) {
                        windows.remove(c2);
                    } else {
                        windows.put(c2, tmp);
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    /**
     * 数组方式
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow1(String s, String t) {
        //用128个长度的数组代替原来的HashMap
        int[] needs = new int[128];
        int[] window = new int[128];
        for (char ch : t.toCharArray()) {
            needs[ch] = needs[ch] + 1;
        }
        int left = 0, right = 0;
        int plength = t.length();
        //候选字符数
        int match = 0;
        int minLength = s.length() + 1;
        String result = "";
        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch] = window[ch] + 1;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                match++;
            }
            right++;
            //滑动窗口中的字符串包含pattern，开始缩小窗口
            while (match == plength) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    match--;
                }
                //找出长度最短符合条件的结果 (right-l)+1计算当前窗口大小
                if (right - left < minLength) {
                    minLength = right - left;
                    result = s.substring(left, right);
                }
                window[ch] = window[ch] - 1;
                left++;
            }
        }
        return result;
    }

}

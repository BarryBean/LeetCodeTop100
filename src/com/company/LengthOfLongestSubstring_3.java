package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @PackageName:com.company
 * @ClassName:LengthOfLongestSubstring_3
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/7 10:38
 */
public class LengthOfLongestSubstring_3 {


    /**
     * 基础版本，可以用Set替换Map
     *
     * @param s
     * @return
     */
    /*public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
        boolean flag = false;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            //字符没遇见过 = 不含重复字符，right往右走
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 1);
                right++;
                flag = true;
            } else {
                //字符重复过，left往左走
                map.remove(s.charAt(left));
                left++;
                flag = false;
            }
            if (flag) {
                maxLen = right - left > maxLen ? right - left : maxLen;
            }
        }
        return maxLen;
    }*/

    /**
     * 用map存下标，每次出现重复字符时，更新left
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            //存下标
            map.put(s.charAt(right), right);
            maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String str = "pwkpwwwkres";
        System.out.println(lengthOfLongestSubstring(str));
    }
}

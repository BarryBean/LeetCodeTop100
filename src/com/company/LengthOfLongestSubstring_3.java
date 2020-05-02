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
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0, maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                map.remove(s.charAt(left));
            }
        }
        return maxLen;
    }

}

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:com.company
 * @ClassName:FindAnagrams_438
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/7 11:25
 */
public class FindAnagrams_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0) {
            return list;
        }
        int left = 0, right = 0, match = 0;
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        //子串可能出现多次
        for (char c : p.toCharArray()) {
            Integer times = needs.getOrDefault(c, 0);
            needs.put(c, times + 1);
        }
        char[] chars = s.toCharArray();

        while (right < chars.length) {
            char c1 = chars[right];
            //模式串有这个字符
            if (needs.containsKey(c1)) {
                Integer times = windows.getOrDefault(c1, 0);
                windows.put(c1, times + 1);
                //一个字符匹配完成
                if (needs.get(c1).equals(windows.get(c1))) {
                    match++;
                }
            }
            right++;
            //窗口已经符合要求
            while (match == needs.size()) {
                if (right - left == p.length()) {
                    //更新list，存left下标
                    list.add(left);
                }
                //存完就向右移动left
                //先检查left位置上的字符是不是要的字符
                char c2 = chars[left];
                if (needs.containsKey(c2)) {
                    Integer tmp = windows.get(c2);
                    tmp--;
                    //如果c2字符出现的次数少于模式串中出现的次数
                    if (tmp < needs.get(c2)) {
                        match--;
                    }
                    //tmp为0就删掉字符
                    if (tmp == 0) {
                        windows.remove(c2);
                    } else {
                        windows.put(c2, tmp);
                    }
                }
                left++;
            }
        }
        return list;
    }
}

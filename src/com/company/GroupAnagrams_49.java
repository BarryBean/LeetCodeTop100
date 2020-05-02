package com.company;

import java.util.*;

/**
 * @author bys
 * @date 2019-11-29 19:37
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}

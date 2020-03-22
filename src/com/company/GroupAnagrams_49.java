package com.company;

import java.util.*;

/**
 * @author bys
 * @date 2019-11-29 19:37
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<String> tempList = new ArrayList<>();

        if (strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String, List> ans = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }
}

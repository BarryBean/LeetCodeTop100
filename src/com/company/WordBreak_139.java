package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:WordBreak_139
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/25 9:40
 */
public class WordBreak_139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}

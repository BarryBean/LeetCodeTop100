package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:LetterCombinations_17
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/22 10:34
 */
public class LetterCombinations_17 {
    public static List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] s = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    s[i] = "abc";
                    break;
                case '3':
                    s[i] = "def";
                    break;
                case '4':
                    s[i] = "ghi";
                    break;
                case '5':
                    s[i] = "jkl";
                    break;
                case '6':
                    s[i] = "mno";
                    break;
                case '7':
                    s[i] = "pqrs";
                    break;
                case '8':
                    s[i] = "tuv";
                    break;
                case '9':
                    s[i] = "wxyz";
                    break;
            }
        }
        process(s, 0, "");
        return list;
    }

    private static List<String> list;

    public static void process(String[] s, int index, String sub) {
        if(index==s.length){
            list.add(sub);
            return;
        }
        for (int i = 0; i < s[index].length(); i++) {
            process(s, index + 1, sub + s[index].charAt(i));
        }
    }
}

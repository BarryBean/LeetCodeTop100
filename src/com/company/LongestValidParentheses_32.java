package com.company;

import java.util.Stack;

/**
 * @author bys
 * @date 2019-11-26 20:48
 */
public class LongestValidParentheses_32 {

    //暴力解法，对每个偶数长度的子字符串进行判断

    public int longestValidParentheses(String s) {
        int maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length(); j+=2) {
                if(isVaild(s.substring(i,j))){
                    maxLen=Math.max(maxLen,j-i);
                }
            }
        }
        return maxLen;
    }

    //判断字符串是否符合要求

    public boolean isVaild(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push('(');
            }else if(!stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

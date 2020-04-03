package com.company;

import java.util.Stack;

/**
 * @author bys
 * @date 2019-11-26 20:48
 */
public class LongestValidParentheses_32 {

    //辅助栈
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - start + 1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s = "()())))(()";
        System.out.println(longestValidParentheses(s));
    }
}

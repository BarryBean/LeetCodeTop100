package com.company;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author bys
 * @date 2019-11-25 18:31
 */
public class IsValid_20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                char top = stack.isEmpty() ? '*' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ;
    }
}

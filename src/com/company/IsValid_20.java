package com.company;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author bys
 * @date 2019-11-25 18:31
 */
public class IsValid_20 {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()%2==1){
            return false;
        }
        //题解做法，除了栈之外借助一个hashmap用来表示括号间的匹配关系
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            //每次遇到右括号就弹出栈顶，用map中检查是否是一致等级的括号
            if(map.containsKey(c)){
                char top = stack.empty()?'*':stack.pop();
                if(top!=map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        //return stack.isEmpty()?true:false;

        //自己做法，if+switch
        for (char c:chars){
          if(c=='('||c=='['||c=='{'){
              stack.push(c);
          }else {
              if(stack.isEmpty()){
                  return false;
              }
              switch (c){
                  case ')':
                      if(stack.peek()!='('){
                          return false;
                      }else {
                          stack.pop();
                      }
                      break;
                  case ']':
                      if(stack.peek()!='['){
                          return false;
                      }else {
                          stack.pop();
                      }
                      break;
                  case '}':
                      if(stack.peek()!='{'){
                          return false;
                      }else {
                          stack.pop();
                      }
                      break;
                  default:return false;
              }
          }
        }
        return stack.isEmpty()?true:false;
    }
}

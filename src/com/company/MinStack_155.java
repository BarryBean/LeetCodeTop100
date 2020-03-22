package com.company;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @PackageName:com.company
 * @ClassName:MinStack_155
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/10 10:23
 */
public class MinStack_155 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
       if(minStack.isEmpty()){
           minStack.push(x);
       }else if(minStack.peek()>x){
           minStack.push(x);
       }else {
           //min和data保持数据同步，高度相同
           minStack.push(minStack.peek());
       }
        stack.push(x);
    }

    public void pop() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}

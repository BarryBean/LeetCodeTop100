package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName:com.company
 * @ClassName:SortColors_75
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/3 9:29
 */
public class SortColors_75 {
    public static void sortColors(int[] nums) {
        int less = -1, more = nums.length;
        int cur = 0;
        while (cur < more) {
            //我们知道1放中间，所以以1作为分界数
            if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] > 1) {
                more--;
                swap(nums, more, cur);
            } else if (nums[cur] < 1) {
                less++;
                swap(nums, less, cur);
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {2};
        sortColors(num);
        int[][] sequence = findContinuousSequence(9);
        System.out.println(sequence);
    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[b] ^ nums[a];
        nums[a] = nums[a] ^ nums[b];
//        int tmp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = tmp;
    }


    public static int[][] findContinuousSequence(int target) {
        List<int[]> arrayLists = new ArrayList<>();
        int count = 0;
        int start = 1, end = 2;
        while (end > start) {
            //求和公式
            int cursum = (end + start) * (end - start + 1) / 2;
            //相等
            if (cursum == target) {
                int[] tmp = new int[end - start + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = start + i;
                }
                arrayLists.add(tmp);
                start++;
            } else if (cursum < target) {
                //小了就扩大范围
                end++;
            } else {
                //大了就缩小范围
                start++;
            }
        }
        return arrayLists.toArray(new int[arrayLists.size()][]);
    }



}

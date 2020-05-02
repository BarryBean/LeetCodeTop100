package com.company;

import java.util.PriorityQueue;

/**
 * @PackageName:com.company
 * @ClassName:FindKthLargest_215
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/28 10:22
 */
public class FindKthLargest_215 {
    /**
     * 小根堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //找大用小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() == k) {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            } else {
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}

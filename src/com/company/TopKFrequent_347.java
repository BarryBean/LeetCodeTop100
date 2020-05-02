package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @PackageName:com.company
 * @ClassName:TopKFrequent_347
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/27 9:29
 */
public class TopKFrequent_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->map.get(o1)-map.get(o2));
        int[] ret = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : map.keySet()) {
            if (queue.size() == k) {
                if (map.get(queue.peek()) < map.get(integer)) {
                    queue.poll();
                    queue.offer(integer);
                } else {
                    continue;
                }
            } else if (queue.size() < k) {
                queue.offer(integer);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
}

package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName:com.company
 * @ClassName:CombinationSum_39
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/3 10:16
 */
public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        if (candidates == null || candidates.length == 0 || target == 0) {
            return lists;
        }
        process(candidates, target, lists, 0, new ArrayList<>(), 0);
        return lists;
    }

    public static void process(int[] candidates, int target, List<List<Integer>> lists, int sum, List<Integer> list, int i) {
        if (sum > target || i > candidates.length - 1) {
            return;
        }

        if (sum == target) {
            lists.add(new ArrayList<>(list));
        }

        for (int j = i; j < candidates.length && sum <= target; j++) {
            sum += candidates[j];
            list.add(candidates[j]);
            process(candidates, target, lists, sum, list, j);
            list.remove(list.lastIndexOf(candidates[j]));
            sum -= candidates[j];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }


}

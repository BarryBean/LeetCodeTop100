package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:CombinationSum2_40
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/2 13:30
 */
public class CombinationSum2_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target == 0) {
            return lists;
        }
        Arrays.sort(candidates);
        process(candidates, lists, target, new ArrayList<>(), 0, 0);
        return lists;
    }

    private static void process(int[] candidates, List<List<Integer>> lists, int target, ArrayList<Integer> list, int i, int sum) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || i > candidates.length - 1) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            sum += candidates[j];
            list.add(candidates[j]);
            process(candidates, lists, target, list, j + 1, sum);
            list.remove(list.size() - 1);
            sum -= candidates[j];
        }
    }
}

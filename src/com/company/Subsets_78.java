package com.company;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @PackageName:com.company
 * @ClassName:Subsets_78
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/12 13:00
 */
public class Subsets_78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        process(nums, 0, new ArrayList<Integer>(), lists);
        return lists;
    }

    public static void process(int[] nums, int i, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            process(nums, j + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }



}

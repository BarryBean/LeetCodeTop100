package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:Merge_56
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/22 9:30
 */
public class Merge_56 {
    private static List<int[]> lists;

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        lists = new ArrayList<>();
        process(intervals);
        int[][] ret = new int[lists.size()][];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = lists.get(i);
        }
        return ret;
    }

    public static void process(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                lists.add(intervals[i - 1]);
                end = intervals[i][1];
                continue;
            }
            int tmp = intervals[i][1];
            intervals[i][1] = end > intervals[i][1] ? end : intervals[i][1];
            end = end < tmp ? tmp : end;
            intervals[i][0] = intervals[i - 1][0];

        }
        lists.add(intervals[intervals.length - 1]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {9, 13}, {12, 19}};
        for (int[] ints : merge(nums)) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.print(",");
        }
    }
}

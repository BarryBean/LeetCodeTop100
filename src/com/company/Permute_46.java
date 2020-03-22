package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:Permute_46
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/13 16:03
 */
public class Permute_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        process(nums, 0, lists, new ArrayList<Integer>());
        return lists;
    }

    public static void process(int[] nums, int i, List<List<Integer>> lists, List<Integer> list) {
        if (i == nums.length) {
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            if (!lists.contains(new ArrayList<>(list))) {
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            process(nums, i + 1, lists, list);
            swap(nums, i, j);
        }
    }


    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    /* String返回值的
    public String[] permutation(String S) {
        if(S==null||S.length()==0) return new String[0];
        List<String> res = new ArrayList<>();
        permute(res, S.toCharArray(), 0);
        return res.toArray(new String[0]);
    }
    private void permute(List<String> res, char[] chs, int index){
        if(index==chs.length){
            res.add(new String(chs));
            return;
        }
        for(int i=index;i<chs.length;i++){
            swap(chs, index, i);
            permute(res, chs, index+1);
            swap(chs, index, i);
        }
    }
    private void swap(char[] chs, int i, int j){
        char c = chs[i];
        chs[i]=chs[j];
        chs[j]=c;
    }
    */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bys
 * @date 2019-11-23 16:35
 */
public class ThreeNum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> arrayList = new ArrayList<>();

        //将数组从小到大排序
        Arrays.sort(nums);

        //a+b+c=0可以看成是a+b=-c，转换为两数之和
        //设置两个指针，分别从左从右往中间遍历，找到a+b+c=0的加入list中
        //若a+b+c<0，说明a+b太小，start++
        //若a+b+c>0，说明a+b太大，end--
        //去重，若两数相同，则位置相邻
        for (int i = 0; i < nums.length; i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int start = i+1,end=nums.length-1,sum=0-nums[i];
                while (start<end){
                    if(nums[start]+nums[end]==sum){
                        arrayList.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        while (start<end && nums[start]==nums[start+1]){
                            start++;
                        }
                        while (start<end && nums[end]==nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(nums[start]+nums[end]<sum){
                        while (start<end && nums[start]==nums[start+1]){
                            start++;
                        }
                        start++;
                    }else {
                        while (start<end && nums[end]==nums[end-1]){
                            end--;
                        }
                        end--;
                    }
                }
            }
        }
        return arrayList;
        /*while (start < end) {
            curr=start+1;
            while (curr<end){
                if((nums[start]+nums[end])==0-nums[curr]){
                    if(!arrayList.contains(Arrays.asList(nums[start],nums[curr],nums[end]))){
                        arrayList.add(Arrays.asList(nums[start],nums[curr],nums[end]));
                    }
                    break;
                }else {
                    curr++;
                }
            }

            if((nums[start]+nums[end])<0){
                start++;
            }else {
                end--;
            }
        }
*/

    }


    public static void main(String[] args) {
        int[] nums={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> arrayList = threeSum(nums);
        System.out.println(arrayList);
    }
}

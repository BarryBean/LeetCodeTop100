package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bys
 * @date 2019-11-23 14:34
 */
public class TwoSum_01 {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x = target - nums[i];
            if(map.containsKey(x)){
                indexs[1]=i;
                indexs[0]=map.get(x);
            }
            map.put(nums[i],i);
        }
        return indexs;
    }
}

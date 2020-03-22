package com.company;

/**
 * @PackageName:com.company
 * @ClassName:CountBits_338
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/1 21:21
 */
public class CountBits_338 {

    /**
     * 按奇偶数划分
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        int count = 0;
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 1) {
                ret[i] = ret[i - 1] + 1;
            } else {
                ret[i] = ret[i / 2];
            }
        }
        return ret;
    }
}

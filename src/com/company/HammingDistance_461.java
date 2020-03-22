package com.company;

/**
 * @PackageName:com.company
 * @ClassName:HammingDistance_461
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/2 10:01
 */
public class HammingDistance_461 {
    /**
     * 每次无符号右移，找到不同的位的个数就是汉明距离
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 && y != 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x >>>= 1;
            y >>>= 1;
        }
        while (x != 0) {
            count = (x & 1) == 1 ? count + 1 : count;
            x >>>= 1;
        }
        while (y != 0) {
            count = (y & 1) == 1 ? count + 1 : count;
            y >>>= 1;
        }
        return count;
    }

    /**
     * 两数异或，剩下的就是不同的位为1
     * n & n-1，会将n最右的1位变成0
     * 从而计算两者距离
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance1(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp != 0) {
            count++;
            tmp &= (tmp - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}

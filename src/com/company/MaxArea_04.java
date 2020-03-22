package com.company;

/**
 * @author bys
 * @date 2019-11-23 15:41
 */
public class MaxArea_04 {
    public static int maxArea(int[] height) {
        //暴力解法 O(n*n)
        /*int max=0;
        for (int i = 0; i < height.length; i++) {
            for (int j=i+1;j<height.length;j++){
                int minHeight = height[i]<height[j]?height[i]:height[j];
                int length = j-i;
                max = (minHeight*length)>max?(minHeight*length):max;
            }
        }
        return max;*/

        //双指针 一个放在开头，一个放在末尾，max保存目前的最大面积
        //每次更新后，将较小的那条线往较大的线方向移动
        int max = 0, tmp = 0, i = 0, j = height.length-1;
        int minHeight = 0, length = 0;
        while (i < j) {
            minHeight = height[i] < height[j] ? height[i] : height[j];
            length = j - i;
            tmp = minHeight * length;
            max = tmp > max ? tmp : max;
            if(height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int a = maxArea(height);
        System.out.println(a);
    }
}

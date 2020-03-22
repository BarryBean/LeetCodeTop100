package com.company;

/**
 * @author bys
 * @date 2019-11-29 19:05
 */
public class Rotate_48 {
    public void rotate(int[][] matrix){
        int length=matrix[0].length;
        //注意此处的限定范围
        for (int i = 0; i < (length + 1) / 2; i++) {
            for (int j = 0; j < length / 2; j++) {
                //顺时针90度旋转相当于第i行变成第n-i列（n取length-1）
                int temp = matrix[length-1-j][i];
                matrix[length-1-j][i]=matrix[length-1-i][length-1-j];
                matrix[length-1-i][length-1-j]=matrix[j][length-1-i];
                matrix[j][length-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}

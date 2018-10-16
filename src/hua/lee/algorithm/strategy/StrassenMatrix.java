package hua.lee.algorithm.strategy;

import java.util.Arrays;

/**
 * Strassen 处理矩阵乘法
 *
 * @author lijie
 * @create 2018-10-14 14:28
 **/
public class StrassenMatrix {
    public static void main(String[] args) {
        int[][] matrxA = new int[][]{
                {1, 9},
                {2, 8},
                {3, 7},
        };
        int[][] matrxB = new int[][]{
                {2, 3, 4},
                {7, 8, 9},
        };

        simple(matrxA,matrxB);
    }

    /**
     * 朴素版，Strassen 没能理解 😂
     * @param mA 矩阵 A
     * @param mB 矩阵 B
     */
    private static void simple(int[][] mA, int[][] mB) {
        int[][] result = new int[mA.length][mB[0].length];

        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mA.length; j++) {
                int len = mB.length;
                int res = 0;
                for (int k = 0; k < len; k++) {
                    res = res + mA[i][k]*mB[k][j];
                }
                result[i][j] = res;
            }
        }

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

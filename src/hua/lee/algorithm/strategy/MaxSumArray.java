package hua.lee.algorithm.strategy;

import java.util.Arrays;

/**
 * 求数组中最大和的连续子数组
 * 分析：最大和子数组设为A[i,j]，则[i,j]存在三种情况: 1：完全位于数组[start,mid]、2：完全位于数组[mid,end]、3：跨越 mid
 * 精髓：分治策略处理此问题。对于
 *
 * @author lijie
 * @create 2018-10-08 13:03
 **/
public class MaxSumArray {

    public static void main(String[] args) {
        int[] array = new int[]{3, -8, -1,};
        int[] res = find(array, 0, array.length - 1);

        System.out.println("find max sub array is [startPos,endPos,sumVal] : " + Arrays.toString(res));
    }

    /**
     * 对于分析中的1、2两种情况，可以通过递归拆分为相同子问题，因为都是在求指定上限（start 和 end 是确定的）的最大和子数组问题。
     * 第3种情况则特殊处理即可
     *
     * @param array 待计算数组
     * @param start 数组起始位置
     * @param end   数组结束位置
     * @return int[最大子数组起始位置、最大子数组结束位置、最大子数组数值]
     */
    private static int[] find(int[] array, int start, int end) {
        //如果数组中只有一个元素，直接返回当前元素
        if (end == start) {
            System.out.println("end == start" + start + " array value = " + array[start]);
            return new int[]{start, end, array[start]};
        }

        int mid = (start + end) / 2;
        //分别当前数组左侧最大值、右侧最大值、和包含 mid 最大值
        int[] left = find(array, start, mid);
        int[] right = find(array, mid + 1, end);
        int[] cross = maxCrossSum(array, start, mid, end);
        //比较最大值并返回
        if (left[2] > right[2] && left[2] > cross[2]) {
            return left;
        } else if (right[2] > left[2] && right[2] > cross[2]) {
            return right;
        } else {
            return cross;
        }
    }

    /**
     * 计算跨越 mid 情况下的最大数组和
     *
     * @param array 待计算数组
     * @param start 起始位置
     * @param mid   中点位置
     * @param end   结束位置
     * @return int[最大子数组起始位置、最大子数组结束位置、最大子数组数值]
     */
    private static int[] maxCrossSum(int[] array, int start, int mid, int end) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int leftPos = 0, rightPos = 0;
        //计算左侧累加最大值和位置
        for (int i = mid; i >= start; i--) {
            System.out.println("array ::: " + array[i]);
            sum = sum + array[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftPos = i;
            }
        }

        System.out.println("start --- mid : max left sum is " + leftSum + "; max left position is " + leftPos);

        sum = 0;
        //计算右侧累加最大值和位置
        for (int i = mid + 1; i <= end; i++) {
            System.out.println("array ::: " + array[i]);
            sum = sum + array[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightPos = i;
            }
        }

        System.out.println("mid --- end : max right sum is " + rightSum + "; max right position is " + rightPos);
        //返回最大和数组
        return new int[]{leftPos, rightPos, leftSum + rightSum};
    }
}

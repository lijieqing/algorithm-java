package hua.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序算法
 *
 * @author lijie
 * @create 2018-11-28 11:53
 **/
public class CountSort extends BaseSort {
    @Override
    public void sort() {

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5, 1, 4, 3, 9, 6, 2,2,1};
        countSort(array, 10);
    }

    /**
     * 计数排序
     * @param array 待排序数组
     * @param k 临时数组长度，取值为排序数组的最大值+1
     *          （此处是因为 array 中的元素被作为数组下标，所以数组长度为最大值+1）
     */
    private static void countSort(int[] array, int k) {
        //创建计数统计数组
        int[] countArray = new int[k];
        //计算 array 中每个元素的重复个数
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] += 1;
        }
        //计算数组中小于当前元素的元素个数
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                countArray[i] = countArray[i] + countArray[i - 1];
            }
        }
        //结果输出数组
        int[] result = new int[array.length];
        //将 array 中的元素存放到 result 指定位置
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println("array:" + array[i] + " | countArray:" + countArray[array[i]]);
            //计算存放位置(小于当前元素的数量值-1即为数组下标)
            int pos = countArray[array[i]] -1;
            //根据计数统计数组将数组array中的元素存放到result数组中
            result[pos] = array[i];
            //小于当前元素的数量值-1
            countArray[array[i]] = pos;
        }

        System.out.println(Arrays.toString(result));

    }
}

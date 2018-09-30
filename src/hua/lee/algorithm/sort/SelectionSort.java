package hua.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 选择排序的精髓: 每次从数组中选出最小元素，替换当前位置
 * 大体流程：
 * 当对数组的第一个元素排序时，从第一个元素开始查找最小的元素，找到后将最小元素和第一个元素交换
 * 继续排序第二个元素，从第二个元素开始查找最小的元素，找到后与第二个元素交换
 * 直到还剩一个元素未排序
 *
 * @author lijie
 * @create 2018-09-29 09:41
 **/
public class SelectionSort extends BaseSort {
    @Override
    public void sort() {

    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 2, 9, 1, 5, 4};
        selectionSort(array);
    }

    private static void selectionSort(int[] array) {
        int temp, minIndex;
        //对每个元素进行选择排序
        for (int i = 0; i < array.length; i++) {
            //将当前位置记录为最小元素位置
            minIndex = i;
            //将当前位置后的元素一一比对，选出最小的元素位置
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //交换元素，将最小元素插入到当前位置
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}

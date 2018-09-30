package hua.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 插入排序的精髓：按顺序从数组的第二个元素位置开始取值作为当前值，位置依次递增。
 * 将当前值与前方位置的元素进行比对（此时前方位置要确保是有序的）
 * 凡大于当前值的元素向后移动
 * 找到小于当前值得位置，插入在其后面
 *
 * 因为从第二个元素开始比较，所以按此方法可以保证当前值所在位置前的元素是有序排列
 *
 * @author lijie
 *
 * @create 2018-09-26 19:51
 **/
public class InsertionSort extends BaseSort {
    public static void main(String[] args) {
        int[] test = new int[]{2, 5, 1, 7, 9, 3};
        insertionSort(test);
    }

    @Override
    public void sort() {

    }

    private static void insertionSort(int[] array) {
        //从第二个元素开始取值比对
        for (int i = 1; i < array.length; i++) {
            //保存当前值
            int cur = array[i];
            //计算前一个元素位置
            int j = i - 1;
            //开启循环计算，将当前值与前面所有元素比对
            //大于当前值的元素向后移动
            while (j >= 0 && array[j] > cur) {
                array[j + 1] = array[j];
                j--;
            }
            //当出现小于当前值的位置，在其后方插入
            array[j + 1] = cur;
        }

        System.out.println(Arrays.toString(array));
    }
}

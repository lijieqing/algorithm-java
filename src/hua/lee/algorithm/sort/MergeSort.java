package hua.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 归并排序的精髓：
 * ① 分解，二分思想，每次将排序数组二分为两个小数组，向下递归分解至数组元素不可分
 * ② 合并，元素不可分(即数组中只有一个元素)时，将两个小数组合并，合并时对数组进行排序，并向上返回
 *
 * @author lijie
 * @create 2018-10-03 09:27
 **/
public class MergeSort extends BaseSort {
    private static int SAFE_GUARD = 999;

    @Override
    public void sort() {

    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 3,};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {//当数组中的元素不可分时，停止分解
            int mid = (start + end) / 2;//计算中间坐标
            mergeSort(array, start, mid);//递归分解数组
            mergeSort(array, mid + 1, end);//递归分解数组
            //合并数组，合并后为有序数组
            //因为前面为递归调用，所以可以保证第一次调用此方法时，子数组长度为1
            mergeArray(array, start, mid, end);
        }
    }

    private static void mergeArray(int[] array, int start, int mid, int end) {
        System.out.println("old array ->" + Arrays.toString(array));
        int[] left = new int[mid - start + 1 //存放数据长度
                + 1];//预留安全守卫
        int[] right = new int[end - mid//存放数据长度
                + 1];//预留安全守卫
        System.arraycopy(array, start, left, 0, left.length - 1);
        System.arraycopy(array, mid + 1, right, 0, right.length - 1);

        left[left.length - 1] = SAFE_GUARD;
        right[right.length - 1] = SAFE_GUARD;

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int l = 0, r = 0;

        for (int i = start; i <= end; i++) {
            if (right[r] == SAFE_GUARD) {
                array[i] = left[l];
            }
            if (left[l] == SAFE_GUARD) {
                array[i] = right[r];
            }
            if (left[l] <= right[r]) {
                array[i] = left[l];
                l++;
            } else {
                array[i] = right[r];
                r++;
            }
        }
        System.out.println("new array ->" + Arrays.toString(array));

    }
}

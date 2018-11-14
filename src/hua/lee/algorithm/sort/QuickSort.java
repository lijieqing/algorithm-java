package hua.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 算法之快速排序
 *
 * @author lijie
 * @create 2018-11-12 21:04
 **/
public class QuickSort extends BaseSort {
    @Override
    public void sort() {

    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 9, 8, 3, 4, 7, 6, 1, 5};

        quickSort(a,0,a.length-1);
        System.out.println(a);
    }

    /**
     * 快速排序
     * @param array 排序数组
     * @param start 数组起始位置
     * @param end 数组结束位置
     */
    private static void quickSort(int[] array, int start, int end) {
        if (start < end){
            //对数组进行分区，记录分区后的样本元素位置点位置
            int mid = partition(array,start,end);
            //对样本元素左侧区域进行递归排序
            quickSort(array,start,mid-1);
            //对样本元素右侧区域进行递归排序
            quickSort(array,mid+1,end);
        }
    }

    /**
     * 数组分区算法
     * 以最后一个元素为样本元素，进行分区
     * 将数组划分为左、中（样本元素存放区域）、右三组。左侧区域小于中，右侧区域大于中
     *
     * @param array 待排序数组
     * @param start 数组开始位置
     * @param end   数组结束位置
     * @return 样本元素位置
     */
    private static int partition(int[] array, int start, int end) {
        int sample = array[end];
        //默认左侧区域为空
        int leftEnd = start - 1;
        int temp;

        for (int j = start; j < end; j++) {
            //如果当前位置元素值小于样本值
            if (array[j] <= sample) {
                //将当前元素移动到左侧区域，即左侧区域空间增加1
                leftEnd++;
                temp = array[leftEnd];
                array[leftEnd] = array[j];
                array[j] = temp;
            }
        }
        //将样本元素移动到中间区域，也就是与左侧区域紧挨着
        //leftEnd + 1 就是样本元素所在位置
        //如此形成左、中、右的区间排布
        temp = array[leftEnd + 1];
        array[leftEnd + 1] = array[end];
        array[end] = temp;

        //输出分区后的数组
        System.out.println(Arrays.toString(array));
        return leftEnd + 1;
    }
}

package hua.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 最大堆排序
 * 精髓：将数组转换为堆结构，将父节点作为最大值存放位置。从下至上依次对父节点堆进行排序，保证 root 点为最大值。
 *
 * @author lijie
 * @create 2018-10-21 18:33
 **/
public class MaxHeapSort extends BaseSort {
    @Override
    public void sort() {

    }

    public static void main(String[] args) {
        int[] array = new int[]{9, -3, 1, 6, 14, 20, -5, 30};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序
     *
     * @param array 排序数组
     */
    private static void heapSort(int[] array) {
        //构建最大堆结构， 构建后的array数组并不能保证是有序的
        //但是每个父节点肯定是最大的
        maxHeapBuild(array);
        System.out.println("first build head ::: "+Arrays.toString(array));
        //用来控制数组的排序范围，因为下面要将得到的最大的数值依次放到最后
        int len = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            System.out.println("root value :: " + array[0]);
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // i 位置被占用，排序数组长度-1
            len--;
            maxHeap(array, 0, len);

            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 将数组构建为最大堆结构
     *
     * @param array 数组
     */
    private static void maxHeapBuild(int[] array) {
        int parentSize = array.length / 2;//计算包含子节点的父节点结束位置
        for (int i = parentSize; i >= 0; i--) {
            maxHeap(array, i, array.length);
        }
    }

    /**
     * 对堆结构进行排序，将最大值作为根节点
     *
     * @param array 堆结构对应数组
     * @param pos   排序堆根节点所在数组中的位置
     * @param len   数组长度
     */
    private static void maxHeap(int[] array, int pos, int len) {
        int l = left(pos);
        int r = right(pos);
        int max = pos;

        if (l < len && array[l] > array[max]) {
            max = l;
        }
        if (r < len && array[r] > array[max]) {
            max = r;
        }
        if (max != pos) {
            int temp = array[pos];
            array[pos] = array[max];
            array[max] = temp;
            //将最大位置的堆再排序，此处是比较绕的点。
            //举例说明：我们先声明二维结构描述，（parent、left、right）
            //堆结构如描述（-3，20，14）（20，6，9）（14，7，8）
            //此时 parent：-3需要和20做交换，交换后为(20,-3,14)(-3,6,9)(14,7,8)
            //此时(-3,6,9)的结构是不对的，所以要对(-3,6,9)的堆结构排序
            //结果为（20，9，14）（9，6，-3）（14，7，8）
            //此时如果-3下还有子节点，还需进行排序（所以递归调用）
            maxHeap(array, max, len);
        }
    }

    /**
     * 根据父节点所在数组位置，计算左叶子位置
     *
     * @param pos 父节点位置
     * @return 左子节点位子
     */
    private static int left(int pos) {
        return 2 * pos + 1;
    }

    /**
     * 根据父节点所在数组位置，计算右叶子位置
     *
     * @param pos 父节点位置
     * @return 右子节点位置
     */
    private static int right(int pos) {
        return 2 * pos + 2;
    }
}

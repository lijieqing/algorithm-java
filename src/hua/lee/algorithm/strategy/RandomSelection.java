package hua.lee.algorithm.strategy;

/**
 * 随机选择顺序统计量
 *
 * @author lijie
 * @create 2018-12-11 23:44
 **/
public class RandomSelection {
    private static int random(int start, int end) {
        return (int) (start + Math.random() * (end - start));
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 4, 2, 3, 6, 7, 2, 8};

        int val = randomSelection(array, 7, 0, array.length - 1);
        System.out.println(val);
    }

    /**
     * 获取数组任意位置的有序元素
     *
     * @param array 输入数组
     * @param pos   查询位置
     * @param start 起始位置
     * @param end   结束位置
     * @return 元素值
     */
    private static int randomSelection(int[] array, int pos, int start, int end) {
        //获取随机分区的样本位置
        int mid = randomPartition(array, start, end);
        //递归结束点，当要获取的 pos=mid 时
        if (pos == mid) {
            return array[mid];
        }
        System.out.println("start:" + start + "|end:" + end + "|pos:" + pos + "|mid:" + mid);
        //递归情况
        if (pos < mid) {
            return randomSelection(array, pos, start, mid - 1);
        } else {
            return randomSelection(array, pos, mid + 1, end);
        }
    }

    /**
     * 随机分区
     *
     * @param array 分区数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 样本位置
     */
    private static int randomPartition(int[] array, int start, int end) {
        //计算随机样本位置
        int samplePos = random(start, end);
        //将随机样本放到数组尾部
        int temp = array[end];
        array[end] = array[samplePos];
        array[samplePos] = temp;

        int sample = array[end];
        //左侧区域默认为空
        int leftEnd = start - 1;
        //检测到小于样本值的数据，放入左侧区域
        for (int i = start; i < end; i++) {
            if (array[i] <= sample) {
                leftEnd++;
                temp = array[leftEnd];
                array[leftEnd] = array[i];
                array[i] = temp;
            }
        }
        //将样本中放到中间区域
        temp = array[end];
        array[end] = array[leftEnd + 1];
        array[leftEnd + 1] = temp;

        return leftEnd + 1;
    }
}

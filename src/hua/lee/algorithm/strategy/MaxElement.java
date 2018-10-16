package hua.lee.algorithm.strategy;

/**
 * 数组最大元素
 *
 * @author lijie
 * @create 2018-10-16 23:07
 **/
public class MaxElement {
    public static void main(String[] args) {
        int[] array = new int[]{-1,9,10,35,-5,34};
        System.out.println(maxValue(array,0,array.length-1));
    }
    private static int maxValue(int[] array,int start,int end){
        if (start==end){
            return array[start];
        }
        int mid = (start+end)/2;
        int l = maxValue(array,start,mid);
        int r = maxValue(array,mid+1,end);
        return l>r?l:r;
    }
}

package hua.lee.algorithm.data_structure;

import java.util.Arrays;

/**
 * 队列
 *
 * @author lijie
 * @create 2019-01-02 20:29
 **/
public class Queue {
    private int head = 0;
    private int tail = 0;
    private int[] data;
    private static final int len = 5;

    public Queue() {
        data = new int[len];
    }

    public void enQueue(int val) {
        if (tail < data.length) {
            data[tail] = val;
            tail++;
        }else {
            throw new RuntimeException("overflow !!");
        }
    }

    public int deQueue() {
        int val ;
        if (head <= tail) {
            val = data[head];
            head++;
            return val;
        }else {
            throw new RuntimeException("no element left");
        }
    }
    public boolean isEmpty(){
        return head == tail;
    }

    public void show(){
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        for (int i = 0; i < 5; i++) {
            q.enQueue(i);
        }

        q.show();

        while (!q.isEmpty()){
            System.out.println(q.deQueue());
        }
    }
}

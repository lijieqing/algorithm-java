package hua.lee.algorithm.data_structure;

import java.util.Arrays;

/**
 * 栈，LIFO
 *
 * @author lijie
 * @create 2018-12-31 20:48
 **/
public class Stack {
    private int top = -1;
    private static final int defalutLen = 20;
    private int[] data;

    public Stack() {
        data = new int[defalutLen];
    }

    /**
     * 判断是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value value
     */
    public void push(int value) {
        if (top <= data.length - 1) {
            top++;
        } else {
            //expand array
        }

        data[top] = value;
    }

    /**
     * 出栈
     * @return value
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("under flow");
        } else {
            top--;
            return data[top + 1];
        }
    }

    public void show() {
        System.out.println(length() + ":=:" + Arrays.toString(data));
    }

    /**
     * 当前数据长度
     * @return len
     */
    public int length() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 8; i++) {
            stack.push((int) (Math.random() * 100));
        }

        stack.show();

        while (stack.length() > 0) {
            System.out.println("pop() :=: " + stack.pop());
        }

    }

}

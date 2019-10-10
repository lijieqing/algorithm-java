package hua.lee.algorithm.operation;

/**
 * 位运算
 *
 * @author lijie
 * @create 2019-10-10 09:27
 **/
@SuppressWarnings("Duplicates")
public class BitOperation {
    /**
     * 按位与运算
     * 对应的两个输入位都是1的情况下才会输出1
     * a = 0b101
     * b = 0b001
     * c = 0b001
     *
     * @param a 数据1
     * @param b 数据2
     */
    private static void AND(int a, int b) {
        System.out.println("----------------AND & AND----------------");
        System.out.println("a = 0b" + Integer.toBinaryString(a));
        System.out.println("b = 0b" + Integer.toBinaryString(b));
        int c = a & b;
        System.out.println("c = 0b" + Integer.toBinaryString(c));
        System.out.println("c = " + c);
        System.out.println("----------------AND & AND----------------");
    }

    /**
     * 按位或运算
     * 对应的两个输入位只要有一个是1，就会输出1
     * a = 0b0101
     * b = 0b1001
     * c = 0b1101
     *
     * @param a 数据1
     * @param b 数据2
     */
    private static void OR(int a, int b) {
        System.out.println("----------------OR | OR----------------");
        System.out.println("a = 0b" + Integer.toBinaryString(a));
        System.out.println("b = 0b" + Integer.toBinaryString(b));
        int c = a | b;
        System.out.println("c = 0b" + Integer.toBinaryString(c));
        System.out.println("c = " + c);
        System.out.println("----------------OR | OR----------------");
    }

    /**
     * 按位异或
     * 对应的两个输入位某一个是1，但不全是1才会输出1
     * a = 0b100
     * b = 0b111
     * c = 0b011
     *
     * @param a 数据1
     * @param b 数据2
     */
    private static void XOR(int a, int b) {
        System.out.println("----------------XOR ^ XOR----------------");
        System.out.println("a = 0b" + Integer.toBinaryString(a));
        System.out.println("b = 0b" + Integer.toBinaryString(b));
        int c = a ^ b;
        System.out.println("c = 0b" + Integer.toBinaryString(c));
        System.out.println("c = " + c);
        System.out.println("----------------XOR ^ XOR----------------");
    }

    /**
     * 按位非（一元运算）
     * 生成与输入位相反的数值，输入0，则输出1；输入1，则输出0
     *
     * @param a 数据1
     */
    private static void NON(int a) {
        System.out.println("----------------NON ~ NON----------------");
        System.out.println("a = 0b" + Integer.toBinaryString(a));
        a = ~a;
        System.out.println("a = 0b" + Integer.toBinaryString(a));
        System.out.println("a = " + a);
        System.out.println("----------------NON ~ NON----------------");
    }

    public static void main(String[] args) {
        AND(0b0100, 0b1111);
        OR(5, 0);
        XOR(0b100, 0b011);
        NON(50);
    }
}

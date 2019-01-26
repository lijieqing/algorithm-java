package hua.lee.algorithm.data_structure;

/**
 * 链表
 *
 * @author lijie
 * @create 2019-01-02 23:25
 **/
public class LinkedList {

    private Node list = null;

    public void addFirst(int val) {
        Node node = new Node();
        node.value = val;
        node.prev = null;
        node.next = list;
        if (list != null) {
            list.prev = node;
        }
        list = node;
    }

    public void addLast(int val) {
        Node node = new Node();
        node.value = val;
        node.next = null;
        node.prev = list;
        if (list != null) {
            list.next = node;
        }
        list = node;

    }

    public void show() {
        Node node = list;
        while (node != null) {
            System.out.println("linked list ==> " + node.value);
            node = node.next;
        }
    }

    class Node {
        private Node prev;
        private Node next;
        private int value;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1000);
        for (int i = 0; i < 9; i++) {
            ll.addFirst(i);
        }
        ll.show();
    }
}

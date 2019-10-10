package hua.lee.algorithm.data_structure;

import com.sun.istack.internal.NotNull;

/**
 * 二叉搜索树
 *
 * @author lijie
 * @create 2019-01-26 20:21
 **/
public class BinarySearchTree {
    private Node root;

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.addValue(5);
        bt.addValue(2);
        bt.addValue(3);
        bt.addValue(7);
        bt.addValue(9);
        bt.show();
    }

    public void show() {
        System.out.println("--------- 前序遍历 ---------");
        preorderTreeWalk(root);
        System.out.println("--------- 中序遍历 ---------");
        inorderTreeWalk(root);
        System.out.println("--------- 后序遍历 ---------");
        postorderTreeWalk(root);
        System.out.println("------max " + maxMum());
        System.out.println("------min " + minMun());
    }

    public void addValue(int key) {
        if (root == null) {
            root = newNode(key);
        } else {
            addValue(root, key);
        }
    }

    public int minMun() {
        if (root == null) {
            throw new IllegalStateException("root is null");
        }
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.key;
    }

    public int maxMum() {
        if (root == null) {
            throw new IllegalStateException("root is null");
        }
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.key;
    }


    private void inorderTreeWalk(Node node) {
        if (node != null) {
            inorderTreeWalk(node.left);
            System.out.println(node.key);
            inorderTreeWalk(node.right);
        }
    }

    private void preorderTreeWalk(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preorderTreeWalk(node.left);
            preorderTreeWalk(node.right);
        }
    }

    private void postorderTreeWalk(Node node) {
        if (node != null) {
            postorderTreeWalk(node.left);
            postorderTreeWalk(node.right);
            System.out.println(node.key);
        }
    }

    private void addValue(@NotNull Node root, int key) {
        Node temp = root;
        Node curNode = null;
        Node val = newNode(key);
        while (temp != null) {
            curNode = temp;
            if (val.key < temp.key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        val.parent = curNode;
        if (curNode != null) {
            if (val.key < curNode.key) {
                curNode.left = val;
            } else {
                curNode.right = val;
            }
        }

    }

    private Node newNode(int key) {
        Node node = new Node();
        node.key = key;
        node.left = null;
        node.right = null;
        node.parent = null;
        return node;
    }

    private class Node {
        int key;
        Node left;
        Node right;
        Node parent;
    }
}

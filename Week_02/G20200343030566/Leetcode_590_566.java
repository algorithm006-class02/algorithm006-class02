package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liguang
 * @Date 2020/2/19
 * @Description
 */

public class Leetcode_590_566 {
    public static void main(String[] args) {

        Leetcode_590_566.Node rootNode = new Leetcode_590_566.Node(1);

        Leetcode_590_566.Node secondNode1 = new Leetcode_590_566.Node(3);
        Leetcode_590_566.Node secondNode2 = new Leetcode_590_566.Node(2);
        Leetcode_590_566.Node secondNode3 = new Leetcode_590_566.Node(4);

        Leetcode_590_566.Node thirdNode1 = new Leetcode_590_566.Node(5);
        Leetcode_590_566.Node thirdNode2 = new Leetcode_590_566.Node(6);

        List<Leetcode_590_566.Node> nodeList = new ArrayList<>();
        nodeList.add(secondNode1);
        nodeList.add(secondNode2);
        nodeList.add(secondNode3);

        List<Leetcode_590_566.Node> nodeList2 = new ArrayList<>();
        nodeList2.add(thirdNode1);
        nodeList2.add(thirdNode2);

        rootNode.children = nodeList;
        secondNode1.children = nodeList2;

        Leetcode_590_566 e = new Leetcode_590_566();
//        List<Integer> integerList = e.preorder(rootNode);
        List<Integer> integerList = e.stackPostOrder(rootNode);
        System.out.println(1);
    }

    ;

    /**
     * 递归的方式处理n叉树后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        postRecursive(root, resList);
        return resList;
    }

    /**
     * 后序遍历--左--》右--》根
     *
     * @param root
     * @param resList
     */
    private void postRecursive(Node root, List<Integer> resList) {
        // terminator
        if (root.children == null) {
            resList.add(root.val);
            return;
        }

        // process login
        // 再深入进去
        for (Node node : root.children) {
            // drill down
            postRecursive(node, resList);
        }

        // 再将根加进去
        resList.add(root.val);
        // return status
        return;
    }

    /**
     * 栈的方式解决后序遍历
     * 左--》右--》根
     *
     * @param root
     * @return
     */
    public List<Integer> stackPostOrder(Node root) {
        LinkedList<Node> stackNode = new LinkedList<>();
        LinkedList<Integer> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }

        // 先把跟加进去
        stackNode.add(root);
        while (!stackNode.isEmpty()) {
            // 先出栈最后一个元素节点
            Node pollLastNode = stackNode.pollLast();
            // 将其加入到链表前面，保证了从左节点到右节点再到根节点的顺序
            resList.addFirst(pollLastNode.val);

            for (Node childNode : pollLastNode.children) {
                // 依次将左右节点进行入栈
                stackNode.add(childNode);
            }
        }
        return resList;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

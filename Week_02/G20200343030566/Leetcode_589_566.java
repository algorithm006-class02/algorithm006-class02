package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liguang
 * N叉树的前序遍历
 */
public class Leetcode_589_566 {
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

    public static void main(String[] args) {

        Leetcode_589_566.Node rootNode = new Leetcode_589_566.Node(1);

        Leetcode_589_566.Node secondNode1 = new Leetcode_589_566.Node(3);
        Leetcode_589_566.Node secondNode2 = new Leetcode_589_566.Node(2);
        Leetcode_589_566.Node secondNode3 = new Leetcode_589_566.Node(4);

        Leetcode_589_566.Node thirdNode1 = new Leetcode_589_566.Node(5);
        Leetcode_589_566.Node thirdNode2 = new Leetcode_589_566.Node(6);

        List<Leetcode_589_566.Node> nodeList = new ArrayList<>();
        nodeList.add(secondNode1);
        nodeList.add(secondNode2);
        nodeList.add(secondNode3);

        List<Leetcode_589_566.Node> nodeList2 = new ArrayList<>();
        nodeList2.add(thirdNode1);
        nodeList2.add(thirdNode2);

        rootNode.children = nodeList;
        secondNode1.children = nodeList2;

        Leetcode_589_566 e = new Leetcode_589_566();
//        List<Integer> integerList = e.preorder(rootNode);
        List<Integer> integerList = e.preOrderWithStack(rootNode);
        System.out.println(1);
    }

    /**
     * 递归解决前序遍历n叉树
     * 根--》左--》右
     *
     * @param root
     * @param resList
     */
    private void recursivePreOrder(Node root, List<Integer> resList) {
        resList.add(root.val);
        // termination
        if (root.children == null) {
            return;
        }

        // process on logic

        // 进入到左边去
        for (int i = 0; i < root.children.size(); i++) {
            //drill down
            recursivePreOrder(root.children.get(i), resList);
        }

        //reverse status
        return;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        recursivePreOrder(root, resList);
        return resList;
    }

    /**
     * 栈的方式解决前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderWithStack(Node root) {
        LinkedList<Node> nodeStackList = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }

        // 先把跟加进去
        nodeStackList.add(root);
        while (!nodeStackList.isEmpty()) {
            // 先将链表中最后一个节点出栈
            Node currentNode = nodeStackList.pollLast();
            resList.add(currentNode.val);

            // 获取左右子节点，压入栈中
            if (currentNode.children != null) {
                // 反转节点
                Collections.reverse(currentNode.children);

                for (Node child : currentNode.children) {
                    nodeStackList.add(child);
                }
            }
        }
        return resList;
    }
}
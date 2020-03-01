package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liguang
 * @Date 2020/2/19
 * @Description
 */

public class Leetcode_429_566 {
    private LinkedList<List<Integer>> resList = new LinkedList<>();

    public static void main(String[] args) {
        Leetcode_429_566.Node rootNode = new Leetcode_429_566.Node(1);

        Leetcode_429_566.Node secondNode1 = new Leetcode_429_566.Node(3);
        Leetcode_429_566.Node secondNode2 = new Leetcode_429_566.Node(2);
        Leetcode_429_566.Node secondNode3 = new Leetcode_429_566.Node(4);

        Leetcode_429_566.Node thirdNode1 = new Leetcode_429_566.Node(5);
        Leetcode_429_566.Node thirdNode2 = new Leetcode_429_566.Node(6);

        List<Leetcode_429_566.Node> nodeList = new ArrayList<>();
        nodeList.add(secondNode1);
        nodeList.add(secondNode2);
        nodeList.add(secondNode3);

        List<Leetcode_429_566.Node> nodeList2 = new ArrayList<>();
        nodeList2.add(thirdNode1);
        nodeList2.add(thirdNode2);

        rootNode.children = nodeList;
        secondNode1.children = nodeList2;

        Leetcode_429_566 e = new Leetcode_429_566();
//        List<Integer> integerList = e.preorder(rootNode);
        List<List<Integer>> integerList = e.queueSolutionLevelOrder(rootNode);
        System.out.println(1);
    }

    /**
     * 递归的形式进行层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return resList;
        }
        recursiveLevelOrder(root, 0);

        return resList;
    }

    /**
     * 递归层次遍历
     *
     * @param root
     * @param level
     */
    private void recursiveLevelOrder(Node root, int level) {
        // termination
        if (resList.size() <= level) {
            resList.add(new ArrayList<>());
        }
        // process current logic
        resList.get(level).add(root.val);
        for (Node child : root.children) {
            recursiveLevelOrder(child, level + 1);
        }
        //return status
        return;
    }

    public List<List<Integer>> queueSolutionLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> insList = new ArrayList<>();

            //当前队列的元素个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node pollNode = queue.poll();
                insList.add(pollNode.val);
                // 将子节点树入队列
                queue.addAll(pollNode.children);
            }
            result.add(insList);
        }
        return result;
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

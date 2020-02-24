package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liguang
 * @Date 2020/2/19
 * @Description
 */

public class Leetcode_49_566 {
    public static void main(String[] args) {
        Leetcode_49_566 solution = new Leetcode_49_566();
        TreeNode root = new TreeNode(1);

        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);

        TreeNode leftLeftNode = new TreeNode(4);
        TreeNode leftRightNode = new TreeNode(5);

        TreeNode rightLeftNode = new TreeNode(6);


        root.left = leftNode;
        root.right = rightNode;

        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;

        rightNode.left = rightLeftNode;
        rightNode.right = null;

        solution.morrisSolution(root);
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        treeSearch(root, integerValList);
        return integerValList;
    }

    /**
     * 递归调用进行中序遍历 左--》根--》右
     *
     * @param root
     * @param integerValList
     */
    private void treeSearch(TreeNode root, List<Integer> integerValList) {
        // terminator
        if (root == null) {
            return;
        }

        // process current logic
        if (root.left != null) {
            // drill down
            treeSearch(root.left, integerValList);
        }
        // 中
        integerValList.add(root.val);
        // 右
        if (root.right != null) {
            // drill down
            treeSearch(root.right, integerValList);
        }

        // reverse current status
        return;
    }

    /**
     * 栈解决树的中序遍历问题 左--》根--》右
     *
     * @param root
     */
    private List<Integer> stackSolution(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        // 用来存贮树节点
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 当前树节点指针
        TreeNode currentNode = root;

        while (currentNode != null && !treeNodeStack.empty()) {
            // 当前节点不为空的情况下压入栈中
            while (currentNode != null) {
                treeNodeStack.push(currentNode);
                // 往左边探寻有没有左节点
                currentNode = currentNode.left;
            }
            // 如果当前节点已经到底了，出栈
            TreeNode popNode = treeNodeStack.pop();
            integerValList.add(popNode.val);
            // 朝右边看看有没有右子树
            currentNode = currentNode.right;
        }
        return integerValList;
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> morrisSolution(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        // 当前树节点指针
        TreeNode currentNode = root;
        // 前置节点
        TreeNode pre = null;

        while (currentNode != null) {
            // 如果没有左子树节点
            if (currentNode.left == null) {
                integerValList.add(currentNode.val);
                currentNode = currentNode.right;
            } else {
                // 有左子树节点
                pre = currentNode.left;
                // 看看右边还有没有节点,找到右子节点最底层的那一个节点
                while (pre.right != null) {
                    pre = pre.right;
                }

                // 将当前节点的前置指针指向pre的右子树
                pre.right = currentNode;

                // 将当前循环的节点的左子树变成空值
                TreeNode temp = currentNode;
                // 将当前节点的左子树节点，置为root节点，
                currentNode = currentNode.left;
                temp.left = null;
            }
        }
        return integerValList;
    }

    /**
     *
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

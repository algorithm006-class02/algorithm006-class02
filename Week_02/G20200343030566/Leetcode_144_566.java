package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liguang
 * @Date 2020/2/19
 * @Description
 */

public class Leetcode_144_566 {
    public static void main(String[] args) {
        Leetcode_144_566 solution = new Leetcode_144_566();
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

//        solution.morrisSolution(root);
//        List<Integer> integerList = solution.preOrderTraversal(root);
        List<Integer> integerList = solution.morrisSolution(root);
        System.out.println(integerList);
    }

    /**
     * 二叉树的前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        preOrderTraversal(root, integerValList);
        return integerValList;
    }

    /**
     * 递归调用进行前序遍历 根--》左--》右
     *
     * @param root
     * @param integerValList
     */
    private void preOrderTraversal(TreeNode root, List<Integer> integerValList) {
        // terminator
        if (root == null) {
            return;
        }

        // process current logic
        // 根
        integerValList.add(root.val);
        // 左
        if (root.left != null) {
            // drill down
            preOrderTraversal(root.left, integerValList);
        }
        // 右
        if (root.right != null) {
            // drill down
            preOrderTraversal(root.right, integerValList);
        }

        // reverse current status
        return;
    }

    /**
     * 栈解决树的前序遍历问题 根--》左--》右
     *
     * @param root
     */
    private List<Integer> stackSolution(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        // 用来存贮树节点
        Stack<TreeNode> treeNodeStack = new Stack<>();
        if (root == null) {
            return integerValList;
        }
        // 先将当前节点压入栈
        treeNodeStack.add(root);

        while (!treeNodeStack.empty()) {
            // 出栈栈顶元素
            TreeNode node = treeNodeStack.pop();
            integerValList.add(node.val);
            // 如果右孩子存在，则将右孩子压入栈中
            if (node.right != null) {
                treeNodeStack.add(node.left);
            }
            // 再压入左孩子节点，先入后出，则左孩子先出栈
            if (node.left != null) {
                treeNodeStack.add(node.right);
            }

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

        while (currentNode != null) {
            // 有没有左子树
            if (currentNode.left == null) {
                // 找到根节点左子树的最右边的子树节点
                integerValList.add(currentNode.val);
                currentNode = currentNode.right;
            } else {
                // 有左子树节点， 找到当前的右子节点，将它归并到左边的最右节点下
                TreeNode currentLeftNode = currentNode.left;

                // 找出左边的最右节点
                while (currentLeftNode.right != null && currentLeftNode.right != currentNode) {
                    currentLeftNode = currentLeftNode.right;
                }

                // 当前节点没有右节点，则将值进行记录
                if (currentLeftNode.right == null) {
                    integerValList.add(currentNode.val);
                    currentLeftNode.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    currentLeftNode.right = null;
                    currentNode = currentNode.right;
                }
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

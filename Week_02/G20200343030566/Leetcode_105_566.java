package com.sebar.test.leetcode;

import java.util.HashMap;

/**
 * @author liguang
 * @Date 2020/2/21
 * @Description 105. 从前序与中序遍历序列构造二叉树
 */

public class Leetcode_105_566 {
    int preIndex = 0;
    int[] preOrder;
    int[] inOrder;
    HashMap<Integer, Integer> idxMap = new HashMap<>();

    public static void main(String[] args) {
        Leetcode_105_566 code = new Leetcode_105_566();
//        TreeNode treeNode = code.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7})
        TreeNode treeNode = code.buildTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
        System.out.println(treeNode);
    }

    /**
     * 前序遍历 根--》左--》右
     * 中序遍历 左--》根--》右
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;

        int idx = 0;
        for (int val : inorder) {
            idxMap.put(val, idx++);
        }

        return bulidATree(0, inorder.length);
    }

    /**
     * 构建二叉树
     *
     * @param left
     * @param right
     * @return
     */
    private TreeNode bulidATree(int left, int right) {
        // terminator
        if (left == right) {
            return null;
        }
        // 前序遍历的第一个元素是根节点
        int rootVal = preOrder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        Integer index = idxMap.get(rootVal);

        preIndex++;
        root.left = bulidATree(left, index);
        root.right = bulidATree(index + 1, right);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

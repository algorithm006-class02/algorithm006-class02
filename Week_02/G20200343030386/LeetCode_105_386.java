package com.example.leetCode.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_105_386 {

    int[] preorder;
    int[] inorder;
    int pre_index;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.pre_index = 0;
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        int curr = preorder[pre_index++];
        TreeNode root = new TreeNode(curr);
        int index = map.get(curr);
        root.left = helper(left, index);
        root.right = helper(index + 1, right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

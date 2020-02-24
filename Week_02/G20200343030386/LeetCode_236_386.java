package com.example.leetCode.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_236_386 {

    private TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        common(root, p, q);
        return node;
    }

    private boolean common(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null) {
            return false;
        }
        int left = common(curr.left, p, q) ? 1 : 0;
        int right = common(curr.right, p, q) ? 1 : 0;
        int mid = (curr == p || curr == q) ? 1 : 0;
        if ((left + right + mid) > 1) {
            this.node = curr;
        }
        return (left + right + mid) > 0;
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

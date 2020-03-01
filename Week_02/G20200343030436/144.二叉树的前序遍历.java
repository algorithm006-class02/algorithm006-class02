/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;

class Solution {
    // 1递归 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    //2 stack + 迭代
    public List<Integer> preorderTraversalMethod2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                rights.push(root.right);
            }
            root = root.left;
            if (root == null && !rights.empty()) {
                root = rights.pop();
            }
        }
        return list;
    }
}
// @lc code=end


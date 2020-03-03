/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        if(left != null && left != p && left != q) return left;

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }else{
            return left == null ? right : left;
        }
    }
}
// @lc code=end


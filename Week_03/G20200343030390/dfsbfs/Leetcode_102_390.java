package com.subject.week03.dfsbfs;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 思路（精简）：
 * 1.递归 dfs
 * O(n)
 *
 * 2.迭代 队列
 * O(n)
 *
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Leetcode_102_390 {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return levels;
        }
        helper(root,0);
        return levels;

    }

    private void helper(TreeNode node, int index) {
        if(levels.size() == index){
            levels.add(new ArrayList<>());
        }
        levels.get(index).add(node.val);

        if(node.left != null){
            helper(node.left,index+1);
        }
        if(node.right != null) {
            helper(node.right,index+1);
        }
    }

}
/*
 * @lc app=leetcode.cn id=111 lang=csharp
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (41.12%)
 * Likes:    213
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 124K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    int minDepth = int.MaxValue;
    public int MinDepth(TreeNode root)
    {
        Helper(root, 1);
        return minDepth == int.MaxValue ? 0 : minDepth;
    }
    void Helper(TreeNode node, int level)
    {
        if (node == null) return;
        if (node.left == null && node.right == null)
            minDepth = minDepth < level ? minDepth : level;
        else
            if (minDepth < level + 1) return;
        Helper(node.left, level + 1);
        Helper(node.right, level + 1);
    }
}
// @lc code=end


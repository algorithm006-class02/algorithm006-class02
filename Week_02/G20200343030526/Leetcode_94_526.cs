/*
 * @lc app=leetcode.cn id=94 lang=csharp
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.78%)
 * Likes:    402
 * Dislikes: 0
 * Total Accepted:    105K
 * Total Submissions: 149.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
using System.Collections.Generic;
public class Solution
{
    public IList<int> InorderTraversal(TreeNode root)
    {
        //中序 左根右
        var r = new List<int>();
        InorderTravel(root, r);
        return r;
    }


    void InorderTravel(TreeNode node, IList<int> result)
    {
        if (node == null) return;
        InorderTravel(node.left, result);
        result.Add(node.val);
        InorderTravel(node.right, result);
    }
}
// @lc code=end


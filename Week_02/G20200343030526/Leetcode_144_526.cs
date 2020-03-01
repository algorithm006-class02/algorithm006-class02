/*
 * @lc app=leetcode.cn id=144 lang=csharp
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (63.66%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    68.4K
 * Total Submissions: 106.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
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
 * 输出: [1,2,3]
 * 
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
    public IList<int> PreorderTraversal(TreeNode root)
    {
        var r = new List<int>();
        //PreorderTraver(root,r);
        Stack<(bool,TreeNode)> stack = new Stack<(bool, TreeNode)>();
        stack.Push((false,root));
        while (stack.Count != 0)
        {
            var node = stack.Pop();
            if(node.Item2 == null) continue;
            if (node.Item1 == false)
            {
                stack.Push((false,node.Item2.right));
                stack.Push((false,node.Item2.left));
                stack.Push((true,node.Item2));
            }
            else r.Add(node.Item2.val);
        }
        return r;
    }

    void PreorderTraver(TreeNode node, IList<int> result)
    {
        //根左右
        if (node == null) return;
        result.Add(node.val);
        PreorderTraver(node.left,result);
        PreorderTraver(node.right,result);
    }
}
// @lc code=end


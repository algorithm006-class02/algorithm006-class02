/*
 * @lc app=leetcode.cn id=102 lang=csharp
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (60.51%)
 * Likes:    391
 * Dislikes: 0
 * Total Accepted:    83.2K
 * Total Submissions: 136.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        var result = new List<IList<int>>();
        if (root == null) return result;
        //bfs
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        while (queue.Count != 0)//把每一层都入队
        {
            int size = queue.Count;//当前层有多少节点
            List<int> tmp = new List<int>();
            for (int i = 0; i < size; i++)//从当前层取出所有节点
            {
                var node = queue.Dequeue();//取节点
                tmp.Add(node.val);
                if (node.left != null) queue.Enqueue(node.left);//把树的左子树入队
                if (node.right != null) queue.Enqueue(node.right);//把树的右子树入队
            }
            result.Add(tmp);
        }
        return result;
    }
}
// @lc code=end


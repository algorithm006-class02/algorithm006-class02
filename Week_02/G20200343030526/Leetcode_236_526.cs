/*
 * @lc app=leetcode.cn id=236 lang=csharp
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (59.25%)
 * Likes:    377
 * Dislikes: 0
 * Total Accepted:    44.9K
 * Total Submissions: 74.9K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
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
public class Solution
{
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        //1.root为当前节点，如果root 为空则返回空
        //2.如果root为p或q，则找到了p或q，返回当前节点
        //如果节点等于p||q则返回当前节点
        if (root == null) return null;
        if (root == p || root == q) return root;
        //递归的重要思路，认为调用时已经获得正确结果。
        //遍历当前节点的左子树，看能不能找到p或q，如果找到了，则不为null
        TreeNode left = LowestCommonAncestor(root.left, p, q);
        //遍历当前节点的右子树，看能不能找到p或q，如果找到了，则不为null
        TreeNode right = LowestCommonAncestor(root.right, p, q);
        if (left == null) return right;//如果左子树为空，返回右子树给上层递归。
        if (right == null) return left;
        if (left != null && right != null) return root;
        return null;

    }
}
// @lc code=end


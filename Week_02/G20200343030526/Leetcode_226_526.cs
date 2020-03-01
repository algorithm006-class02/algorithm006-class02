/*
 * @lc app=leetcode.cn id=226 lang=csharp
 *
 * [226] 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (73.51%)
 * Likes:    363
 * Dislikes: 0
 * Total Accepted:    53.6K
 * Total Submissions: 72.5K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * 输出：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
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
    public TreeNode InvertTree(TreeNode root)
    {
        if (root != null)
        {
            Helper(root);
        }
        return root;
    }

    void Helper(TreeNode node)
    {
        if (node.left == null && node.right == null) return;
        var tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        if (node.left != null) Helper(node.left);
        if (node.right != null) Helper(node.right);
    }
}
// @lc code=end


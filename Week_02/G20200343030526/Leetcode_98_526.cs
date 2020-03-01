/*
 * @lc app=leetcode.cn id=98 lang=csharp
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (28.54%)
 * Likes:    413
 * Dislikes: 0
 * Total Accepted:    69K
 * Total Submissions: 238.4K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
    long lastvalue = long.MinValue;//因为测试用例里有int.minvalue.所以只能取更小值作为初始值
    bool result = true;
    public bool IsValidBST(TreeNode root)
    {
        //中序遍历，左根右，每次取值跟前一次比
        Helper(root);
        return result;
    }

    void Helper(TreeNode node )
    {
        if(node == null || result == false) return;
        Helper(node.left);
        if(lastvalue >= node.val) 
        {
            result = false;
            return ;
        } 
        lastvalue = node.val;
        Helper(node.right);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=105 lang=csharp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (63.70%)
 * Likes:    347
 * Dislikes: 0
 * Total Accepted:    43.9K
 * Total Submissions: 68.3K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

    public TreeNode BuildTree(int[] preorder, int[] inorder)
    {
        //前序遍历 根->左、右
        //中序遍历 左、根、右
        idx = new Dictionary<int, int>();
        for (int i = 0; i < inorder.Length; i++)
        {
            idx.Add(inorder[i], i);
        }
        return Helper(preorder, inorder, 0, inorder.Length - 1);
    }

    int pi = 0;
    Dictionary<int, int> idx;
    TreeNode Helper(int[] preorder, int[] inorder, int left, int right)
    {
        //如果左边界和右边界相等，表示当前子树已经处理完了。
        if (left > right) return null;
        //取当前的根元素，构造当前子树的根节点
        var val = preorder[pi++];
        TreeNode node = new TreeNode(val);
        //left sub tree
        int i = idx[val];//拆分左右子树的依据
        node.left = Helper(preorder, inorder, left, i - 1);
        node.right = Helper(preorder, inorder, i + 1, right);
        return node;
    }

}
// @lc code=end


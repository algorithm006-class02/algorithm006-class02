/*
 * @lc app=leetcode.cn id=515 lang=csharp
 *
 * [515] 在每个树行中找最大值
 *
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (57.85%)
 * Likes:    54
 * Dislikes: 0
 * Total Accepted:    6.4K
 * Total Submissions: 11K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 您需要在二叉树的每一行中找到最大的值。
 * 
 * 示例：
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * 输出: [1, 3, 9]
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
    public IList<int> LargestValues(TreeNode root)
    {
        //思路，1.bfs。
        //2.dfs。
        var r = new List<int>();
        if(root == null) return r;
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        int level = -1;
        while (queue.Count != 0)
        {
            level++;
            int size = queue.Count;
            for (int i = 0; i < size; i++)
            {
                var node = queue.Dequeue();
                if (level > r.Count - 1)
                    r.Add(node.val);
                else
                    if (r[level] < node.val)
                    r[level] = node.val;
                if (node.left != null) queue.Enqueue(node.left);
                if (node.right != null) queue.Enqueue(node.right);
            }
        }
        return r;
        // dfs(root, 0, r);
    }

    // void dfs(TreeNode node, int level, IList<int> result)
    // {
    //     //terminator
    //     if (node == null) return;
    //     //process
    //     if (level > result.Count - 1)
    //         result.Add(node.val);
    //     else
    //         if (result[level] < node.val)
    //         result[level] = node.val;
    //     dfs(node.left, level + 1, result);
    //     dfs(node.right, level + 1, result);
    // }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=429 lang=csharp
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.21%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    14.2K
 * Total Submissions: 21.9K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Solution
{
    public IList<IList<int>> LevelOrder(Node root)
    {
        var r = new List<IList<int>>();
        LevelOrderTravel(root,0, r);
        return r;
    }

    void LevelOrderTravel(Node node,int level, IList<IList<int>> result)
    {
        if (node == null)
        {
            return;
        }
        if (level + 1 > result.Count)
        {
            result.Add(new List<int>());
        }
        result[level].Add(node.val);
        if (node.children != null && node.children.Count > 0)
        {
            foreach (var child in node.children)
            {
                LevelOrderTravel(child,level + 1,result);
            }
        }
    }
}
// @lc code=end


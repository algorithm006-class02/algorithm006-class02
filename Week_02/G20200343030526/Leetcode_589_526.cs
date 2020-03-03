/*
 * @lc app=leetcode.cn id=589 lang=csharp
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.70%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    18K
 * Total Submissions: 25K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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

    public Node(int _val,IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Solution
{
    public IList<int> Preorder(Node root)
    {
        var r = new List<int>();
        PreorderTravel(root, r);
        return r;
    }

    void PreorderTravel(Node node, IList<int> result)
    {
        if (node == null) return;
        result.Add(node.val);
        foreach (var n in node.children)
        {
            PreorderTravel(n,result);
        }
    }
}
// @lc code=end


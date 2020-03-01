/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.85%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 25.5K
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
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    private List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node node) {
        // 下面节点不存在了结束
        if (node == null){
            return;
        }
        // 添加树的节点的值
        res.add(node.val);
        int size = node.children.size();
        for (int i = 0 ; i < size ;i ++){
            // 进入树的下一层
            helper(node.children.get(i));
        }
    }
}
// @lc code=end


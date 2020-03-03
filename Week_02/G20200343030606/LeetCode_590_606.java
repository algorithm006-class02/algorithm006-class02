/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (71.86%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 22.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/*
// Definition for a Node.

import java.util.*;

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
    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node node) {
        // 下面节点不存在了结束
        if (node == null){
            return;
        }
        int size = node.children.size();
        for (int i = 0 ; i < size ;i ++){
            // 进入树的下一层
            helper(node.children.get(i));
        }
        // 添加树的节点的值
        res.add(node.val);
    }
}
// @lc code=end


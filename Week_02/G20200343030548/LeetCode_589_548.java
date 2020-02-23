/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
import java.util.List;
import java.util.ArrayList;
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        List<Node> children = root.children;
        for(Node node: children){
            preorder(node);
        }
        return result;
    }
}
// @lc code=end


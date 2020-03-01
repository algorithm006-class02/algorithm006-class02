/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return result;
        }
        List<Node> children = root.children;
        for(Node node: children){
            postorder(node);
        }
        result.add(root.val);
        return result;
    }
}
// @lc code=end


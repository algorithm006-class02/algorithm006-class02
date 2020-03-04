/* 589. N叉树的前序遍历
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

import java.util.*;

class LeetCode_589_600 {
    //递归
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(Node root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        for(Node node : root.children) {
            helper(node, res);
        }
    }

    //迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            //根节点加入结果集
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
            }
        }
        return res;
    }
}
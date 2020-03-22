import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;


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
    public List<Integer> postorder(Node root) {
        // return postorder_v1(root);
        return postorder_v2(root);
    }
    public List<Integer> postorder_v1(Node root) {
        // 递归
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;

    }
    private void helper(Node node, List<Integer> res) {
        if (node != null) {
            for (Node child : node.children) {
                helper(child, res);
            }
            res.add(node.val);
        }
    }
    public List<Integer> postorder_v2(Node root) {
        Deque<Node> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            res.add(node.val);
            for (Node child : node.children) {
                stack.addFirst(child);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
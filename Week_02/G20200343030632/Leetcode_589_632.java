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
    public List<Integer> preorder(Node root) {
        return preorder_v2(root);
    }
    public List<Integer> preorder_v1(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    private void helper(Node node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            for (Node n : node.children) {
                helper(n, res);
            }
        }
    }
    public List<Integer> preorder_v2(Node root) {
        // 迭代
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.addFirst(node.children.get(i));
            }

        }
        return res;
    }

    
}
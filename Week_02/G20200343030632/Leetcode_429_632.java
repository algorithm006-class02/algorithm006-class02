import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
    public List<List<Integer>> levelOrder(Node root) {
        // return levelOrder_v1(root);
        return levelOrder_v2(root);
    }
    public List<List<Integer>> levelOrder_v1(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            helper(0, root, res);
        }
        return res;
    }
    private void helper(int level, Node root, ArrayList<List<Integer>> res) {
        if (res.size() == level) {
            res.add(level, new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node n : root.children) {
            helper(level + 1, n, res);
        }
    }

    public List<List<Integer>> levelOrder_v2(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> cur = new LinkedList<>();
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node node = queue.pollFirst();
                cur.add(node.val);
                for (Node n : node.children) {
                    queue.offerLast(n);
                }
            }
            res.add(cur);
        }

        return res;
    }
}
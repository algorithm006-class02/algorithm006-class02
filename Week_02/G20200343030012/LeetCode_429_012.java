import java.util.ArrayList;
import java.util.List;

/**
 * 429. N叉树的层序遍历 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */

 
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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverseNode(0, result, root);
        return result;
    }

    void traverseNode(final int level, List<List<Integer>> result, final Node node) {
        if (node == null) { return; }

        if (level >= result.size()) { 
            result.add(level, new ArrayList<Integer>());
        }
        result.get(level).add(node.val);

        if (node.children == null) { return; }
        for (int i = 0; i < node.children.size(); i++) {
            traverseNode(level + 1, result, node.children.get(i));
        }
    }
}
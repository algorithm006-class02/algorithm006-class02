import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null){
            return Collections.emptyList();
        }

        LinkedList<Node> stack = new LinkedList<Node>();
        stack.add(root);

        while(stack.size() > 0){
            LinkedList<Node> node1 = new LinkedList<Node>();
            List<Integer> r = new ArrayList<Integer>();

            stack.forEach((n)->{
                node1.addAll(n.children);
                r.add(n.val);
            });

            stack = node1;
            output.add(r);
        }

        return output;
    }
}
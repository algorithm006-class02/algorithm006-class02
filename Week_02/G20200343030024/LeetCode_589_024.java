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

class SolutionWithRecursion {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList();
        result.add(root.val);
        for (Node child : root.children) {
            result.addAll(preorder(child));
        }
        return result;
    }
}

class SolutionWithStack {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();
        
        if (root == null){
            return Collections.emptyList();
        }
        
        stack.add(root);
        while (stack.size() != 0) {
            Node node = stack.pollLast();
            result.add(node.val);

            if (node.children == null || node.children.size() == 0) {
                continue;
            }
    
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
    
        return result;
    }
}
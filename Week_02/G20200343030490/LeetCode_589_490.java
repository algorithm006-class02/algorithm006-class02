import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-23 21:41
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_589_490 {

    private List<Integer> result = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.children != null) {
            root.children.forEach(children -> {
                preorder(children);
            });
        }
        return result;
    }

    public List<Integer> preorderRecursion(Node root) {
        if (root == null) {
            return result;
        }
        Stack<Node> childrenList = new Stack<>();
        childrenList.push(root);

        while (!childrenList.isEmpty()) {
            Node current = childrenList.pop();
            result.add(current.val);
            if (current.children != null) {
                for (int i = current.children.size() - 1; i >= 0; i--) {
                    childrenList.push(current.children.get(i));
                }
            }
        }

        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

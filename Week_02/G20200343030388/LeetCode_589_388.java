import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_388 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null) {
            return res;
        }

        res.add(root.val);

        for (Node item : root.children) {
            preorder(item);
        }

        return res;

    }
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
};
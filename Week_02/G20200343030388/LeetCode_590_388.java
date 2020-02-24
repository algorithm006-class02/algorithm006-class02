import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_388 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {

        if (root == null) {
            return;
        }

        for (Node item : root.children) {
            helper(item, res);
        }
        res.add(root.val);

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
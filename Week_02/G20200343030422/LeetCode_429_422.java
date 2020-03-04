import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_422 {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root != null) {
            List<Node> l = new ArrayList<Node>();
            l.add(root);
            helper(res, l);
        }

        return res;
    }

    public void helper(List<List<Integer>> res, List<Node> l) {

        List<Integer> temp = new ArrayList<Integer>();
        List<Node> tempNode = new ArrayList<Node>();

        for (Node i : l) {
            temp.add(i.val);

            for (Node j : i.children)
                tempNode.add(j);
        }

        if (temp.size() == 0) {
            return;
        } else {
            res.add(temp);
            helper(res, tempNode);

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
    }
}


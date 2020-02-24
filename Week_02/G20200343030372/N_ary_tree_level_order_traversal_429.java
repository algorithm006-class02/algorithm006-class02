package G20200343030372;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen.C
 * @date 2020/2/20
 */
public class N_ary_tree_level_order_traversal_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        recursive(root, 0, output);
        return output;
    }

    private void recursive(Node root, int depth, List<List<Integer>> output) {
        if (root == null) {
            return;
        }
        if (depth + 1 > output.size()) {
            output.add(new ArrayList<>());
        }
        output.get(depth).add(root.val);

        for (Node node : root.children) {
            if (node != null) {
                recursive(node, depth + 1, output);
            }
        }
    }

    static class Node {

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

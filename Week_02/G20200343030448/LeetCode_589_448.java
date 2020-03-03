package G20200343030448;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_448 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        return result;
    }
}

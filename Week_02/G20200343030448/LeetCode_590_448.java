package G20200343030448;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_448 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        result.add(root.val);
        return result;
    }
}

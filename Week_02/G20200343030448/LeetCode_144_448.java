package G20200343030448;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_448 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
}

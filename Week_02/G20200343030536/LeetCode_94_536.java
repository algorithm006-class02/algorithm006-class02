import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_94_536
 * @date : 2020/2/21 11:56 下午
 */
public class LeetCode_94_536 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null) { return; }
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
}

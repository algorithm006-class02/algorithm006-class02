import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_144_536
 * @date : 2020/2/21 11:59 下午
 */
public class LeetCode_144_536 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null) { return; }
        res.add(node.val);
        dfs(node.left, res);
        dfs(node.right, res);
    }
}

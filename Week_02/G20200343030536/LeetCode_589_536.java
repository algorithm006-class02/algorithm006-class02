import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_589_536
 * @date : 2020/2/22 12:09 上午
 */
public class LeetCode_589_536 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        for (Node child : node.children) {
            dfs(child, res);
        }
    }
}

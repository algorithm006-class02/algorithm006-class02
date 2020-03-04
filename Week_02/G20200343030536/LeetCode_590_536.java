import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_590_536
 * @date : 2020/2/22 12:02 上午
 */
public class LeetCode_590_536 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            dfs(child, res);
        }
        res.add(node.val);
    }

}

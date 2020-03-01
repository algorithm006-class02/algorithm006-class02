import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Hyuk
 * @description : LeetCode_104_536
 * @date : 2020/2/22 7:40 下午
 */
public class LeetCode_104_536 {

    public int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
            res++;
        }
        return res;
    }


    private int res = 0;

    public int maxDepth2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            res = Math.max(res, depth);
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) { return 0; }
        int left = maxDepth3(root.left);
        int right = maxDepth3(root.right);
        return Math.max(left, right) + 1;
    }
}

import java.util.Deque;
import java.util.LinkedList;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        // bfs 广度优先
        Deque<TreeNode> queue = new LinkedList<>();
        int res = 1;
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left == null && cur.right == null) {
                    return res;
                }
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
            }
            res++;
        }
        return res;
    }
}
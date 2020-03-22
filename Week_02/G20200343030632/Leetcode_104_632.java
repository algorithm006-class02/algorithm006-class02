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
    public int maxDepth(TreeNode root) {
        // return maxDepth_v1(root);
        return maxDepth_v2(root);
    }

    public int maxDepth_v1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth_v1(root.left), maxDepth_v1(root.right)) + 1;
    }
    public int maxDepth_v2(TreeNode root) {
        // 迭代
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            res ++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
            }
        }
        return res;
    }
}
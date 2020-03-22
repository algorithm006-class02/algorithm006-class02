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
    public TreeNode invertTree(TreeNode root) {
        // 迭代
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeFirst();
            if (cur != null) {
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                stack.addFirst(cur.left);
                stack.addFirst(cur.right);

            }
        }
        return root;
    }
}
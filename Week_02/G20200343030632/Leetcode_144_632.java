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
    public List<Integer> preorderTraversal(TreeNode root) {
        // return preorderTraversal_v1(root);
        return preorderTraversal_v2(root);
    }

    public List<Integer> preorderTraversal_v1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode cur, List<Integer> res) {
        if (cur != null) {
            res.add(cur.val);
            helper(cur.left, res);
            helper(cur.right, res);
        }
    }

    public List<Integer> preorderTraversal_v2(TreeNode root) {
        // 迭代
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            root = root.right;
        }
        return res;

    }
}
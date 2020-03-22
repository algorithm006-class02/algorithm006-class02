import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // return inorderTraversal_v1(root);
        return inorderTraversal_v2(root);
    }

    public List<Integer> inorderTraversal_v1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            helper(node.left, res);
            res.add(node.val);
            helper(node.right, res);
        }
    }

    public List<Integer> inorderTraversal_v2(TreeNode root) {
        // 迭代, 利用栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
        
            root = stack.removeFirst();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    
}
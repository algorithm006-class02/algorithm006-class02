package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BTreePreorderTraversal {
    private List<Integer> list = new ArrayList<>();

    public static void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        root.right = node;

        List<Integer> list = new BTreePreorderTraversal().preorderTraversal(root);
        for (int val : list) {
            System.out.print(val + " ");
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        // 所谓的先序，就是先把头节点给处理了
        list.add(root.val);
        // 再左后右
        if (root.left != null) {
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}

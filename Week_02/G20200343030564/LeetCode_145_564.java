package Week02;

import Week02.Entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 */
public class LeetCode_145_564 {

    public static void main(String[] args) {
        LeetCode_145_564 leetCode = new LeetCode_145_564();

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;

//        List<Integer> out = leetCode.postorderTraversal(root);

        List<Integer> out = new ArrayList<Integer>();
        leetCode.postorderTraversa2(root, out);
        System.out.println(out);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> out = new LinkedList<Integer>();

        if (root == null) {
            return out;
        }

        // 后序遍历：左右根
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            out.addFirst(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return out;

    }


    /**
     * 递归
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param root
     * @return
     */
    public void postorderTraversa2(TreeNode root, List<Integer> out) {
        if (root != null) {
            if (root.right != null) {
                postorderTraversa2(root.right, out);
            }
            if (root.left != null) {
                postorderTraversa2(root.left, out);
            }
            out.add(root.val);
        }
    }
}

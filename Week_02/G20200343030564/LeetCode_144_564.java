package Week02;

import Week02.Entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的前序遍历
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */
public class LeetCode_144_564 {

    public static void main(String[] args) {
        LeetCode_144_564 leetCode = new LeetCode_144_564();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;

        List<Integer> result = leetCode.preorderTraversal(root);
        System.out.println(result);
    }

    /**
     * 运用栈
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> out = new LinkedList<Integer>();

        if (root == null) {
            return out;
        }

        // 先把第一root放入在链表中
        stack.add(root);
        while (!stack.isEmpty()) {
            // 拿出最后一个值
            TreeNode node = stack.pollLast();
            out.add(node.val);

            // 因为是栈：先进后出，所以先迭代右边的
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return out;
    }
}

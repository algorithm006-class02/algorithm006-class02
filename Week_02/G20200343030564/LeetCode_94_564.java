package Week02.pratice;

import Week02.Entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序遍历:左根右
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
public class LeetCode_94_564 {

    public static void main(String[] args) {
        LeetCode_94_564 leetCode = new LeetCode_94_564();

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;

        List<Integer> res = new ArrayList<Integer>();
//        leetCode.inorderTraversal1(root, res);
        leetCode.inorderTraversal2(root, res);
        System.out.println(res);
    }

    /**
     * 递归
     * 时间复杂度：O(n)：每个节点都要访问一次
     * 空间复杂度：最坏是O(n)，平均是O(logn)
     *
     * @param root
     * @return
     */
    public void inorderTraversal1(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal1(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inorderTraversal1(root.right, res);
            }
        }
    }

    /**
     * 栈
     * 时间复杂度：O(n)：每个节点都要访问一次
     * 空间复杂度：O(n)
     *
     * @param root
     */
    public void inorderTraversal2(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 左边值
            cur = stack.pop();
            res.add(cur.val);

            cur = cur.right;
        }
    }

    /**
     * 莫里斯遍历
     *
     *
     * @param root
     * @param res
     */
    public void inorderTraversal3(TreeNode root, List<Integer> res) {

    }
}

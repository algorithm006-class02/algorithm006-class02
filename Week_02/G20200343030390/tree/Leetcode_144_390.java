/**
 *
 * 144.二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗
 *
 *
 * 思路（精简）：
 * 1.递归
 *
 *
 * 2.迭代
 *
 *
 *
 */
public class Leetcode_144_390 {
    /**
     * 1.递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root != null) {
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }

    /**
     * 2.迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }


}
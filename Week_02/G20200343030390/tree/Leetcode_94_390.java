/**
 *
 * 49.二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 * 思路（精简）：
 * 中序遍历 左-根-右
 * 1.递归
 * 时间复杂度：O(n)。递归函数 T(n) = 2⋅T(n/2)+1。
 * 空间复杂度：最坏情况下需要空间O(n)，平均情况为O(logn)。
 *

 * 2.基于栈的遍历
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 *
 *    public class TreeNode {
 *         int val;
 *         TreeNode left;
 *         TreeNode right;
 *
 *         TreeNode(int x) {
 *             val = x;
 *         }
 *     }
 */
public class Leetcode_94_390 {

    /**
     *  1.递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List< Integer > res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 2.基于栈的遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalTwo(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

}

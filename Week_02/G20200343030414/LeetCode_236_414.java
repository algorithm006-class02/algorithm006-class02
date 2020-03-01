package Week_02.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @since 2020-02-23 17:29
 */
public class LeetCode_236_414 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    /**
     * 1、DFS + 剪枝
     * <p>
     *     剪枝算法：
     *        顾名思义，穷竭搜索会把所有可能的解都检查一遍，当解空间非常大时，复杂度也会相应的变大。
     *        比如n个元素进行排列时状态数总共有n！个，复杂度也就成了o(n!)。这样的话，即使n=15计算也很难较早终止。
     *        深度优先搜索时，有时早已很明确的知道从当前状态无论如何转移都不会存在解。
     *        这种情况下，不再继续搜索而是直接跳过，这一方法叫做剪枝。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件：若当前节点为null、p、q之一，直接返回当前节点
        if (root == null || root == p || root == q) return root;
        // 进入下一层：分别进入自己的左孩子，右孩子
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 若左子树、右子树返回值均为非null，则肯定为一个p，一个q，则公共节点为当前节点
        if (left != null && right != null) return root;
        // 若左子树返回非null，则函数返回值为左子树返回值
        // 左左子树返回null，则函数返回值为右子树返回值
        return left != null ? left : right;
    }

}

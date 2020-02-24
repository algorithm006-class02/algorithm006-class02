package com.sebar.test.leetcode;

import java.util.*;

/**
 * @author liguang
 * @Date 2020/2/19
 * @Description
 */

public class Leetcode_236_566 {
    private TreeNode ans;

    public Leetcode_236_566() {
        this.ans = null;
    }

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node2.left = node7;
        node2.right = node4;

        node1.left = node0;
        node1.right = node8;

        Leetcode_236_566 code = new Leetcode_236_566();
        TreeNode node = code.lowestCommonAncestor(node3, node5, node4);

    }

    /**
     * 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return this.ans;
    }

    private Boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        // 先查看左子树
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // 再查看右子树
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // 如果当前节点是p或者q的一个，则代表着找到了目标节点
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // 找到目标节点
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        return (mid + left + right > 0);
    }

    /**
     * 队列解决二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode dequeLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 构建队列
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        parentMap.put(root, null);
        stack.push(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.left);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package Week_02.G20200343030414;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @since 2020-02-23 15:58
 */

public class LeetCode_144_414 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x;}
    }

    /**
     * 1、通过递归解决
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    private void recursive(TreeNode root, List<Integer> res) {
        if (root != null) { // 终止条件
            res.add(root.val); // 处理当前层逻辑
            if (root.left != null) {
                recursive(root.left, res); // 进入下一层
            }
            if (root.right != null) {
                recursive(root.right, res); // 进入下一层
            }
        }
        // 清理当前层垃圾，因为都是局部变量，故无需清理
    }

    /**
     * 2、借助栈先进后出的特性解决
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

}

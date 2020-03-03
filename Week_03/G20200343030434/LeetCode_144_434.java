package algorithm.leetCode.week02.No144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ltw
 * on 2020-02-23.
 */
public class Solution {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    List<Integer> list = new ArrayList<>();
//    //solution1: 递归方式
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (null != root) {
//            list.add(root.val);
//        } else {
//            return list;
//        }
//        if (null != root.left) {
//            preorderTraversal(root.left);
//        }
//        if (null != root.right) {
//            preorderTraversal(root.right);
//        }
//        return list;
//    }

    //solution: 迭代
    //创建栈空间
    //0.将中间节点加入list
    //1.将中间节点加入stack
    //2.判断中间节点是否有左右节点，有将右左节点加入stack(先加右子树 再加左子树)
    //3.pop出stack最上面节点，重复1,2，3 直到所有数据弹出

    Stack<TreeNode> stack = new Stack<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right); //先入栈右子树
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}


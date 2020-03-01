package algorithm.leetCode.week02.No94;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

//    solution1:时间复杂度 O(n) 空间复杂度 O(n)
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null != root) {
            if (null != root.left) {
                inorderTraversal(root.left);
            }
            list.add(root.val);
            if (null != root.right) {
                inorderTraversal(root.right);
            }
        }
        return list;
    }

    //solution2: 基于栈实现 //todo
//    public class Solution implements InvocationHandler {
//        public List < Integer > inorderTraversal(TreeNode root) {
//            List < Integer > res = new ArrayList < > ();
//            Stack < TreeNode > stack = new Stack < > ();
//            TreeNode curr = root;
//
//
//            while (curr != null || !stack.isEmpty()) {
//                while (curr != null) {
//                    stack.push(curr);
//                    curr = curr.left;
//                }
//                curr = stack.pop();
//                res.add(curr.val);
//                curr = curr.right;
//            }
//
//            return res;
//        }
//    }


}


package com.gsf.geekbang_demo.arithmetic.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 */
public class Demo590 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res){
        if (root != null) {
            List<Node> childList = root.children;
            if (childList != null && !childList.isEmpty()) {
                for (Node child : childList) {
                    helper(child, res);
                }
            }
            res.add(root.val);
        }
    }
}

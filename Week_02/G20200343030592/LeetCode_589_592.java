package com.gsf.geekbang_demo.arithmetic.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 */
public class Demo589 {
    // Definition for a Node.
    class Node {
        public int        val;
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

    /*
    第一种
     */
    public List<Integer> preorder1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> outPut = new LinkedList<>();
        if (root == null) return outPut;

        stack.add(root);
        while(!stack.isEmpty()) {
            //取出栈最后一个元素
            Node node = stack.pollLast();
            outPut.add(node.val);
            //栈的特性:先入后出
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return outPut;
    }

    /*
    第二种
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            List<Node> childList = root.children;
            if (childList != null && !childList.isEmpty()) {
                for (Node child : childList) {
                    helper(child, res);
                }
            }
        }
    }
}

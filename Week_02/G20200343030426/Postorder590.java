package com.ping.leetcode.easy.postorder590;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 高一平
 * @Date: 2020/2/23
 * @Description: 给定一个 N 叉树，返回其节点值的后序遍历。
 **/
public class Postorder590 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        getVal(root, result);
        return result;
    }

    private void getVal(Node node, List<Integer> result) {
        if (node != null) {
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    getVal(child, result);
                }
            }
            result.add(node.val);
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();

        if (root == null) {
            return result;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);

            List<Node> children = node.children;
            for (Node child : children) {
                stack.add(child);
            }
        }
        return result;
    }
}

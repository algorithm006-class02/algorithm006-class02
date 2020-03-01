package com.leetcode.base.week02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N 叉数的前序、后序迭代
 * 使用LinkedList链表（双向链表），在头部或者尾部插入元素，维护其元素顺序
 */
public class TreePostOrder {

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorder_1(Node root) {
        helper(root);
        return res;
    }
    public void helper(Node root) {
        if(root == null) {
            return;
        }
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
        res.add(root.val);
    }

    public List<Integer> preorder_2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }

}


class Node{
    public int val;
    public List<Node> children;

    public Node() {

    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
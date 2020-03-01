package com.example.leetCode.week2;

import java.util.*;

public class LeetCode_589_386 {

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            list.add(pop.val);
            Collections.reverse(pop.children);
            for (Node node : pop.children) {
                stack.push(node);
            }
        }
        return list;
    }

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
    };

}

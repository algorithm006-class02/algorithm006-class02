package com.example.leetCode.week2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_386 {

    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            list.addFirst(pop.val);
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

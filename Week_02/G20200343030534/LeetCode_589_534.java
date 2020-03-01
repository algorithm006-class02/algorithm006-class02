package com.test.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Two ways to resove this issue:
 * 1. method preorder: uses iteration
 * 2. method preorderRecursive: uses recursive
 */
public class NaryTreePreorderTranversal589 {

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        List list1 = new ArrayList();
        list1.add(node1);
        list1.add(node2);
        Node node3 = new Node(3, list1);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        List list2 = new ArrayList();
        list2.add(node3);
        list2.add(node4);
        list2.add(node5);
        Node root = new Node(1, list2);

        List<Integer> result = preorder(root);
    }

    public static List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.add(currentNode.val);
            if (currentNode.children != null) {
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    stack.add(currentNode.children.get(i));
                }
            }
        }

        return result;
    }

    // pre-order: root, left, right,
    public List<Integer> preorderRecursive(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        helper(result, root);
        return result;
    }

    private void helper(LinkedList<Integer> result, Node root) {
        if (root != null) {
            result.add(root.val);

            if (root.children != null && !root.children.isEmpty()) {
                for (Node node : root.children) {
                    helper(result, node);
                }
            }

        }
    }
}

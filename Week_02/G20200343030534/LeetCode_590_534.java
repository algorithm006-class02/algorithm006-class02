package com.test.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * There are two ways to resolve this issue:
 * 1. method postorder: uses iteration
 * 2. method postorderRecursive: uses recursive
 */
public class NaryTreePostorderTranversal590 {

    public static void main(String[] args) {

    }
    
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.addFirst(currentNode.val);
            if(currentNode.children != null && !currentNode.children.isEmpty()) {
                stack.addAll(currentNode.children);
            }
        }
    
        return result;
    }

    // post-order: left, right, root
    public List<Integer> postorderRecursive(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        helper(result, root);
        return result;
    }


    private void helper(LinkedList<Integer> result, Node root) {
        if (root != null) {
            if (root.children != null && !root.children.isEmpty()) {
                for(Node node: root.children) {
                    helper(result, node);
                }
            }
            
            result.add(root.val);
        }
    }
}

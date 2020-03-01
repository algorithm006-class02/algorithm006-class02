package com.ping.leetcode.easy.preorder589;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 高一平
 * @Date: 2020/2/23
 * @Description: 给定一个 N 叉树，返回其节点值的前序遍历。
 **/
public class Preorder589 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        getVal(root, result);
        return result;
    }

    private void getVal(Node node, List<Integer> result) {
        if (node != null) {
            List<Node> children = node.children;
            result.add(node.val);
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    getVal(child, result);
                }
            }
        }
    }

    /**
     * 我们使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点
     * 我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点
     * 随后每次我们从栈顶取出一个节点 u
     * 它是我们当前遍历到的节点
     * 并把 u 的所有子节点逆序推入栈中
     * 例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v3, v2, v1
     * 这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);

            List<Node> children = node.children;
            Collections.reverse(children);
            for (Node item : children) {
                stack.add(item);
            }
        }
        return result;
    }

}


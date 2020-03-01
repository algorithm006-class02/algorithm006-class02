package com.youzi.leetcode;//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class PreorderN {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            // 不改变原树结构
            if (node.children != null && !node.children.isEmpty()) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.add(node.children.get(i));
                }
            }
        }
        return result;
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
    }
}
//leetcode submit region end(Prohibit modification and deletion)

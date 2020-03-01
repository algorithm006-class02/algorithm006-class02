package com.youzi.leetcode;
//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder (Node root, List<Integer> result) {
        if (root != null) {
            if (null != root.children && !root.children.isEmpty()) {
                for (Node node : root.children) {
                    postorder(node, result);
                }
            }
            result.add(root.val);
        }
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

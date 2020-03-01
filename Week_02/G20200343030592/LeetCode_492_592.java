package com.gsf.geekbang_demo.arithmetic.leetCode.week02;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 */
public class Demo492 {
    // Definition for a Node.
    class Node {
        public int        val;
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

    public List<List<Integer>> levelOrder(Node root) {
        //因子节点可能会缺少，用map储存每层的集合
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (root != null) {
            map.put(-1, new ArrayList<>(Arrays.asList(root.val)));
            helper(root, map, 0);
        }
        return new ArrayList(map.values());
    }

    private void helper(Node root, Map<Integer, List<Integer>> map, Integer level) {
        if (root != null) {
            List<Node> children = root.children;
            Integer num = level + 1;
            if (children != null && !children.isEmpty()) {
                List<Integer> list;
                if (map.containsKey(level)) {
                    list = map.get(level);
                } else {
                    list = new ArrayList<>();
                }
                for (Node node : children) {
                    list.add(node.val);
                    helper(node, map, num);
                }
                map.put(level, list);
            }
        }
    }
}

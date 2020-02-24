package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class TreePreorderTraversal {
    private List<Integer> list = new ArrayList<>();

    public static void test() {
        List<Node> list = new ArrayList<>();
        list.add(new Node(5));
        list.add(new Node(6));

        Node node = new Node(3);
        node.children = list;

        List<Node> rootList = new ArrayList<>();
        rootList.add(node);
        rootList.add(new Node(2));
        rootList.add(new Node(4));

        Node root = new Node(1);
        root.children = rootList;

        TreePreorderTraversal traversal = new TreePreorderTraversal();
        List<Integer> postorder = traversal.preorder(root);
        for (Integer value : postorder) {
            System.out.print(value + " ");
        }
    }

    public List<Integer> preorder(Node root) {
        // 递归法
        // 后序遍历 -> 左右中
        helper(root);
        return list;
    }

    private void helper(Node root) {
        // 终结条件：空节点
        if (root == null) {
            return;
        }

        // 当前层没有子节点了，则目标值就找到了
        // 前序与后序的区别就在这里
        list.add(root.val);

        // 当前层逻辑就是继续寻找最左子节点
        List<Node> children = root.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                // 继续下探
                helper(children.get(i));
            }
        }
    }

    private static class Node {
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

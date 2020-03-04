package week2;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class TreePostorderTraversal {
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

        TreePostorderTraversal traversal = new TreePostorderTraversal();
        List<Integer> postorder = traversal.postorderWithLoop(root);
        for (Integer value : postorder) {
            System.out.print(value + " ");
        }
    }

    public List<Integer> postorder(Node root) {
        // 递归法
        // 后序遍历 -> 左右中
        helper(root);
        return list;
    }

    private void helper(Node node) {
        // 终结条件：空节点
        if (node == null) {
            return;
        }
        // 当前层逻辑就是继续寻找最左子节点
        List<Node> children = node.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                // 继续下探
                helper(children.get(i));
            }
        }

        // 当前层没有子节点了，则目标值就找到了
        list.add(node.val);
    }

    public List<Integer> postorderWithLoop(Node root) {
        // 遍历法-链表实现—想办法将节点从后序方式（左-右-中）加入一个栈
        List<Integer> result = new LinkedList<>();

        // 我们首先把根节点入栈。当每次我们从栈顶取出一个节点时，就把该节点的所有子节点顺序推入栈中。
        // 这样就保证了下一个遍历到的节点出现在栈顶的位置。
        // 在遍历结束之后，我们把遍历结果反转，就可以得到后序遍历。
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            if (node != null) {
                result.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        stack.add(child);
                    }
                }
            }
        }
        // 反转结果 1 4 2 3 6 5 —> 5 6 3 2 4 1
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorderWithStack(Node root) {
        // 遍历法——栈实现，稍微简洁点
        List<Integer> result = new LinkedList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                result.add(0, node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        stack.push(child);
                    }
                }
            }
        }
        return result;
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

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-23 21:38
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_590_490 {

    LinkedList<Integer> result = new LinkedList<>();

    /**
     * 二叉树的深度优先搜索 都是借助于一个Stack 来辅助实现的
     *
     * @param root
     * @return
     */
    public List<Integer> postorderLoop(Node root) {
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.addFirst(current.val);
            List<Node> childrenList = current.children;
            if (childrenList != null) {
                childrenList.forEach(children -> {
                    stack.push(children);
                });
            }
        }
        return result;
    }

    /**
     * 递归 思路就是假设一件事已经做完 去递归其他的情况
     *
     * @param root
     * @return
     */
    public List<Integer> postorderRecursion(Node root) {
        if (root == null) {
            return result;
        }
        List<Node> childList = root.children;
        if (childList != null) {
            for (Node child : childList) {
                postorderRecursion(child);
            }
        }
        result.add(root.val);
        return result;
    }

    class Node {
        public int val;
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
}

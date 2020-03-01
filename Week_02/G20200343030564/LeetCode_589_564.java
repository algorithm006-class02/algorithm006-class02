package Week02;

import Week02.Entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class LeetCode_589_564 {
    public static void main(String[] args) {
        LeetCode_589_564 leetCode = new LeetCode_589_564();

        List<Node> childrenList2 = new ArrayList<Node>();
        childrenList2.add(new Node(5));
        childrenList2.add(new Node(6));

        List<Node> childrenList = new ArrayList<Node>();
        childrenList.add(new Node(3, childrenList2));
        childrenList.add(new Node(2));
        childrenList.add(new Node(4));

        Node root = new Node(1, childrenList);

        List<Integer> res = new LinkedList<Integer>();
        leetCode.preorder1(root, res);
//        leetCode.preorder2(root, res);
        System.out.println(res);
    }

    /**
     * 迭代
     * 时间复杂度：O(M):其中 MM 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次
     * 空间复杂度：O(M)O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1M−1 个节点，因此栈的大小为 O(M)O(M)
     *
     * @param root
     * @param res
     * @return
     */
    public List<Integer> preorder1(Node root, List<Integer> res) {
        LinkedList<Node> stack = new LinkedList<Node>();
        if (root == null) {
            return res;
        }

        // 前序遍历，根左右
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.add(node.val);

            // 因为是栈的思想(后进先出)，所以先把右边的数插入到栈中
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    if (node.children.get(i) != null) {
                        stack.add(node.children.get(i));
                    }
                }
            }
        }

        return res;
    }

    /**
     * 递归
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param root
     * @return
     */
    public void preorder2(Node root, List<Integer> out) {
        if (root == null) {
            return;
        }
        out.add(root.val);

        List<Node> children = root.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i) != null) {
                    preorder2(children.get(i), out);
                }
            }
        }
    }
}

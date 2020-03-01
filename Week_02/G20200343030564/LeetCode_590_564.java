package Week02;

import Week02.Entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class LeetCode_590_564 {

    public static void main(String[] args) {
        LeetCode_590_564 leetCode = new LeetCode_590_564();

        List<Node> childrenList2 = new ArrayList<Node>();
        childrenList2.add(new Node(5));
        childrenList2.add(new Node(6));

        List<Node> childrenList = new ArrayList<Node>();
        childrenList.add(new Node(3, childrenList2));
        childrenList.add(new Node(2));
        childrenList.add(new Node(4));

        Node root = new Node(1, childrenList);

        List<Integer> res = leetCode.postorder(root);
        System.out.println(res);
    }

    /**
     * 迭代
     * 时间复杂度：O(M)，其中 MM 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次
     * 空间复杂度：O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1M−1 个节点，因此栈的大小为 O(M)O(M)
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> out = new LinkedList<Integer>();

        if (root == null) {
            return out;
        }

        // 后序遍历：左右根
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            // 头插法
            out.addFirst(node.val);

            // 让右边先遍历，因为头插法，最后打印是左右根顺序
            if (node.children != null) {
                for (Node chil : node.children) {
                    if (chil != null) {
                        stack.add(chil);
                    }
                }
            }
        }
        return out;
    }
}

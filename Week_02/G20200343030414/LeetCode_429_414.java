package Week_02.G20200343030414;

import java.util.*;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @since 2020-02-23 16:13
 */
public class LeetCode_429_414 {

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

    /**
     * 1、递归解决
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        recursive(root, 1, res); // level 从 1 开始
        return res;
    }

    private void recursive(Node root, int level, List<List<Integer>> res) {
        if (root == null) return; // 终止条件
        // 处理当前层逻辑
        if (level > res.size()) {// 如果是新的一层，res 内部需要给新的这一层维护一个 List<Integer>
            res.add(new LinkedList<>());
        }
        res.get(level - 1).add(root.val); // 直接将新的这一层的节点加入到 res 在这一层维护的 List<Integer> 中即可
        // 进入下一层
        for (Node node : root.children) {
            recursive(node, level + 1, res);
        }
    }

    /**
     * 2、使用队列解决
     * <p>
     *     1、ArrayDeque是Deque接口的一个实现，使用了可变数组，所以没有容量上的限制。
     *     2、ArrayDeque是线程不安全的，在没有外部同步的情况下，不能再多线程环境下使用。
     *     3、ArrayDeque是Deque的实现类，可以作为栈来使用，效率高于Stack，也可以作为队列来使用，效率高于LinkedList。
     *     4、需要注意的是，ArrayDeque不支持null值。
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevelList = new LinkedList<>();
            int size = queue.size(); // 一整层的节点数量
            while (size > 0) {
                Node currNode = queue.poll();
                currLevelList.add(currNode.val);
                if (currNode.children != null) {
                    queue.addAll(currNode.children);
                }
                size --;
            }
            res.add(currLevelList);
        }
        return res;
    }

}

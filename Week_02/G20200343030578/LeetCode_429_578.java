//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
// Definition for a Node.
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
};
*/
class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>(); // 存储结果
        Deque<Node> deque = new LinkedList<>();         // 用队列暂存结点
        List<Integer> list = new ArrayList<>();         // 存储每层元素

        if(root == null){                               // 注意 root 为空的情况！
            return result;
        }

        deque.offer(root);                              // 根节点点入队
        Node last = root;                               // 标记本层的最后一个结点，
                                                        // 用于后面判断是否要进入下一层

        while (!deque.isEmpty()) {                      // 当队不空时
            Node node = deque.poll();                   // 队头元素出队

            if(node != null){                           // 注意判断 node 是否为空！
                list.add(node.val);                     // 将其加入本层元素列表
                if (node.children.size() != 0) {        // 将其孩子节点入队
                    for (Node child : node.children) {
                        deque.offer(child);
                    }
                }
            }

            if (last == node) {                         // 此条件说明，本层元素遍历完成
                result.add(list);                       // 将本层结果加入最终结果列表
                list = new ArrayList<>();               // 新建一个列表，存储下一层元素
                last = deque.peekLast();                // 本层最后一个元素已经遍历完了，
                                                        // 这说明本层的所有孩子节点都已入队，
                                                        // 也就是说此时队尾元素，即为下一层最后一个元素，
                                                        // 所以利用 deque.peekLast()来更新last
            }
        }

        return result;
    }
}

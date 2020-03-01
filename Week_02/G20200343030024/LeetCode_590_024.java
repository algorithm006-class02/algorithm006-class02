import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

class SolutionWithRecursion {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList();

        for (Node child : root.children) {
            result.addAll(postorder(child));
        }

        result.add(root.val);
        return result;
    }
}

class SolutionWithStack {
    // 思路：
    //   1. 根一定是最后一个输出的, 
    //   2. 左孩子一定是最后输出的，所以每次把值插入到双向链表的头部最开始就可以了
    // 同理，先序遍历：根一定是第一个输出的，只要把遍历的节点添加到链表中就行
    // 过程：
    //  1. 重复执行的单元： 先把根加到双向链表的头部，
    //  2. 遍历所有的子树
    public static List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();

        if (root != null){
            return Collections.emptyList();
        }

        stack.add(root);
        while (stack.size() != 0) {
            Node node = stack.pollLast(); 
            result.addFirst(node.val); 
            for (Node child : node.children) {
                if (child != null){
                    stack.add(child);  
                }          
            }
        }
    
        return result;
    }
}
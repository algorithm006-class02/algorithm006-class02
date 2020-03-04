import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_589_004 {

    ArrayList<Integer> data = new ArrayList();

    /***  递归写法1，借鉴后序遍历 ***/
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return data;
        }

        data.add(root.val);
        for(Node node : root.children) {
            preorder(node);
        }

        return data;
    }

    /***  迭代写法，国际站讨论区解法 ***/
    public List<Integer> preorder2(Node root) {
        if(root == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node nodeWillPop = stack.pop();
            data.add(nodeWillPop.val);
            for(int i = nodeWillPop.children.size()-1;i>=0;i++) {
                stack.push(nodeWillPop.children.get(i));
            }
        }

        return data;
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

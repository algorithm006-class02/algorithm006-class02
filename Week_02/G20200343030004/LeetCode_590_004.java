import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_004 {

    ArrayList<Integer> data = new ArrayList();

    /***  递归写法1，自己所想 ***/
    public List<Integer> postorder(Node root) {
        if (root == null)
            return data;

        //递归终结条件
        if (root.children == null || root.children.size() == 0) {
            // 处理结果
            data.add(root.val);
            return null;
        }
        // 下探到下一层
        for (Node node : root.children) {
            postorder(node);
        }

        // 处理当前层逻辑
        data.add(root.val);
        return data;
    }

    /***  递归写法2，国际站讨论区解法 ***/
    public List<Integer> postorder2(Node root) {
        ArrayList<Integer> data = new ArrayList();
        if(root == null) {
            return data;
        }

        for(Node node : root.children) {
            postorder(node);
        }
        data.add(root.val);
        return data;
    }

    /***  迭代写法，国际站讨论区解法 ***/
    public List<Integer> postorder3(Node root) {
        if(root == null) {
            return null;
        }

        ArrayList<Integer> data = new ArrayList();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node nodeWillPop = stack.pop();
            data.add(0,nodeWillPop.val);
            for(Node node:nodeWillPop.children) {
                stack.push(node);
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

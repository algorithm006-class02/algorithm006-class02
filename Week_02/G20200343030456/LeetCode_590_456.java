import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_590 {

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<Integer>();
            this.postorder1(root, result);
            return result;
        }

        //递归方法
        private void postorder1(Node root, List<Integer> list) {
            //判断终止条件
            if (root == null) {
                return;
            }
            List<Node> children = root.children;
            if (children == null || children.size() == 0) {
                list.add(root.val);
                return;
            }
            //逻辑处理

            //下一次递归
            //先递归子节点
            for (int i = 0; i < children.size(); i++) {
                Node node = children.get(i);
                this.postorder1(node, list);
            }
            //添加节点本身
            list.add(root.val);
            //reverse the current level status if needed
        }

        //利用栈，按照前序的方式进行遍历
        private List<Integer> postorder2(Node root) {
            LinkedList<Integer> result = new LinkedList<Integer>();
            LinkedList<Node> stack = new LinkedList<Node>();

            if(root == null){
                return result;
            }

            stack.add(root);
            while (!stack.isEmpty()){
                Node node = stack.pollLast();
                result.addFirst(node.val);
                for (Node child : node.children) {
                    if(child != null){
                        stack.add(child);
                    }
                }
            }
            return result;
        }
    }


    // Definition for a Node.
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_589 {


    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<Integer>();
            this.preorder1(root, result);
            return result;
        }

        //递归的方式
        private void preorder1(Node root, List<Integer> list) {
            //截至条件
            if (root == null) {
                return;
            }

            //逻辑处理
            list.add(root.val);

            //下一次迭代
            List<Node> children = root.children;
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    this.preorder1(child, list);
                }
            }
        }

        //迭代的方式
        private List<Integer> preorder2(Node root) {
            List<Integer> result = new ArrayList<Integer>();
            LinkedList<Node> stack = new LinkedList<Node>();

            if (root == null) {
                return result;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                result.add(node.val);

                List<Node> children = node.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    if (children.get(i) != null) {
                        stack.add(children.get(i));
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

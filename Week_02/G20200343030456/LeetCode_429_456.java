import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_429 {

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            this.levelOrder1(root, 0, result);
            return result;
        }

        //递归
        private void levelOrder1(Node root, int level, List<List<Integer>> list) {
            //终止条件
            if (root == null) {
                return;
            }

            //逻辑处理
            if (list.size() <= level) {
                list.add(level, new ArrayList<Integer>());
            }

            list.get(level).add(root.val);
            level++;
            //下次递归
            for (Node child : root.children) {
                this.levelOrder1(child, level, list);
            }
        }

        //遍历
        private List<List<Integer>> levelOrder2(Node root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            LinkedList<ArrayList<Node>> stack = new LinkedList<ArrayList<Node>>();

            if (root == null) {
                return result;
            }

            ArrayList<Node> nodes = new ArrayList<Node>();
            nodes.add(root);
            stack.add(nodes);
            while (!stack.isEmpty()) {
                ArrayList<Node> childNodes = new ArrayList<Node>();
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (Node rootNode : stack.pollLast()) {
                    list.add(rootNode.val);
                    childNodes.addAll(rootNode.children);
                }
                result.add(list);

                if(childNodes.size() > 0){
                    stack.add(childNodes);
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

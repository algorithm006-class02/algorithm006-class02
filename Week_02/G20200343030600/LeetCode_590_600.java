/* 590. N叉树的后序遍历
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

import java.util.*;

class Solution {
    //递归
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(Node root, List<Integer> res) {
            if(root == null) return;
            for(Node node : root.children) {
                helper(node, res);
            }
            res.add(root.val);
    }

    //迭代
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //前指针
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            //当节点无孩子或所有孩子都被访问
            if ((cur.children.size() == 0) || (cur.children.contains(pre))) {
                //加入结果集 
                res.add(cur.val);
                stack.pop();
                //更新pre指针
                pre = cur;
            } else {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return res;
    }
}
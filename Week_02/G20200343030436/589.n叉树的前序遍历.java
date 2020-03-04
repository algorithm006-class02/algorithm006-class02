/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
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
class Solution {
    //1 递归
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node: root.children) {
            preorder(node);
        }
        return list;
    }

    //2 迭代
    public List<Integer> preorderMethod2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);//根
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return list;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ColorNode{
        public String color;
        public TreeNode node;
        public ColorNode(TreeNode node, String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }    
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));
        while(!stack.empty()){
            ColorNode cn = stack.pop();
            if(cn.node == null) continue;
            if("white".equals(cn.color)){
               stack.push(new ColorNode(cn.node.right,"white"));
               stack.push(new ColorNode(cn.node.left,"white"));
               stack.push(new ColorNode(cn.node,"gray"));
            }else{
                result.add(cn.node.val);
            }
        }
        return result;
    }
}
// @lc code=end


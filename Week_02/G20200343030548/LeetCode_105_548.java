/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }
    public TreeNode buildTree(int[] preorder,int p_start, int p_end, int[] inorder,int i_start, int i_end, Map<Integer,Integer> map) {
        if(p_start == p_end){
            return null;
        }
        int rootValue = preorder[p_start];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        int leftNum = rootIndex - i_start;
        root.left = buildTree(preorder,p_start+1, p_start+1+leftNum,inorder,i_start,rootIndex,map);
        root.right = buildTree(preorder,p_start+1+leftNum,p_end,inorder,rootIndex+1,i_end,map);
        return root;
    }
}
// @lc code=end


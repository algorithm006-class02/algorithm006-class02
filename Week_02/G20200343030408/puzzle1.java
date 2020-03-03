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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result){
        if(root != null){
            if(root.left!=null){
              helper(root.left,result);  
            }
                result.add(root.val);
            if(root.right!= null){
                helper(root.right,result);
            }
        }
    }
}
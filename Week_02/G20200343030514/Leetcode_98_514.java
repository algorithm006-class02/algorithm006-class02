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
    //这意味着我们需要在遍历树的同时保留结点的上界与下界，在比较时不仅比较子结点的值，"也要与上下界比较"。
    public boolean isValidBST(TreeNode root) {
        
        return helper(root, null, null);

    }
    
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        
        int value = root.val;
     
        if (lower != null && value <= lower ) {
            return false;
        }
        if (upper != null && value >= upper) {
            return false;
        }
          
        return helper(root.left, lower, value) && helper(root.right, value, upper);
    
    }
}

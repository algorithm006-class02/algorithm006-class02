class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if(left!=null) return left;
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(right!=null) return right;
        if(reach(root,p.val)==true&&reach(root,q.val)==true) return root;
        return null;
    }
    public boolean reach(TreeNode root,int value){
        if(root == null) return false;
        if(root.val == value) return true;
        return reach(root.left,value) || reach(root.right,value);
    }
}

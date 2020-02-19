class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int fpoi, int lpoi, int[] inorder, int fioi, int lioi) {
        if (lpoi - fpoi == 0) {
            TreeNode root = new TreeNode(preorder[lpoi]);
            return root;
        }
        TreeNode root = new TreeNode(preorder[fpoi]);
        int rootIndexInorder = indexOf(inorder, fioi, lioi, root.val);
        int leftLength = rootIndexInorder - fioi;
        int rightLength = lioi - rootIndexInorder;
        if (leftLength > 0) {
            root.left = buildTree(preorder, fpoi + 1, fpoi + leftLength, inorder, fioi, fioi + leftLength - 1);
        }
        if (rightLength > 0) {
            root.right = buildTree(preorder, fpoi + leftLength + 1, fpoi + leftLength + rightLength, inorder, rootIndexInorder + 1, rootIndexInorder + rightLength);
        }
        return root;

    }

    private int indexOf(int[] inorder, int fpoi, int lpoi, int num) {
        for (int i = fpoi; i <= lpoi; i++) {
            if (inorder[i] == num) {
                return i;
            }
        }
        return 0;
    }
}
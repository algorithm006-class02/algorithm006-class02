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
        int rioi = indexOf(inorder, fioi, lioi, root.val);
        int lsl = rioi - fioi;//左子树的长度
        int rsl = lioi - rioi;//右子树的长度
        if (lsl > 0) {
            root.left = buildTree(preorder, fpoi + 1, fpoi + lsl, inorder, fioi, fioi + lsl - 1);
        }
        if (rsl > 0) {
            root.right = buildTree(preorder, fpoi + lsl + 1, fpoi + lsl + rsl, inorder, rioi + 1, rioi + rsl);
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
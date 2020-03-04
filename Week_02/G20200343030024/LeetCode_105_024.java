

class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        new Solution().buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode treeNode = buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
            System.out.println(treeNode);

            return treeNode;
        }

        public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inOrderStart,
            int inOrderStop) {
            if (preStart == preEnd) {
                return null;
            }

            int value = preorder[preStart];
            // 先从中序遍历中读取根
            TreeNode root = new TreeNode(value);

            int i = inOrderStart;
            for (; i < inOrderStop; i++) {
                if (inorder[i] == value) {
                    break;
                }
            }

            int leftNumber = i - inOrderStart;

            // 找到left节点所在index
            root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftNumber + 1, inorder, inOrderStart, i);
            root.right = buildTreeHelper(preorder, preStart + leftNumber + 1, preEnd, inorder, i + 1, inOrderStop);
            return root;
        }
    }

}


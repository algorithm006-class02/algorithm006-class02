/**
 * @author : Hyuk
 * @description : LeetCode_105_536
 * @date : 2020/2/23 7:30 下午
 */
public class LeetCode_105_536 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||
            inorder == null || inorder.length == 0 ||
            preorder.length != inorder.length) {
            return null;
        }

        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd ) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = -1;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == node.val) {
                index = i;
                break;
            }
        }

        node.left = build(preorder, preStart + 1, inorder, inStart, index - 1);
        node.right = build(preorder, preStart + (index - inStart) + 1, inorder, index + 1, inEnd);
        return node;
    }
}

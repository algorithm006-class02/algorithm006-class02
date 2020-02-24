/**
 * @author : Hyuk
 * @description : LeetCode_236_536
 * @date : 2020/2/23 7:19 下午
 */
public class LeetCode_236_536 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { return root; }
        return left != null ? left : right;
    }
}

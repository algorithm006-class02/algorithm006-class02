/**
 * @author : Hyuk
 * @description : LeetCode_226_536
 * @date : 2020/2/22 7:12 下午
 */
public class LeetCode_226_536 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return root; }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

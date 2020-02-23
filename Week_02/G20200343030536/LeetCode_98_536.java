/**
 * @author : Hyuk
 * @description : LeetCode_98_536
 * @date : 2020/2/22 7:17 下午
 */
public class LeetCode_98_536 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) { return true; }
        if (min != null && node.val <= min || max != null && node.val >= max) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}

/**
 * @author : Hyuk
 * @description : LeetCode_297_536
 * @date : 2020/2/23 3:56 下午
 */
public class LeetCode_297_536 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { return "null"; }
        String str = root.val + "#";
        return str + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}

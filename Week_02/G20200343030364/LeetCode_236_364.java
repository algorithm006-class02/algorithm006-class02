/**
 * Created by HuGuodong on 2/23/20.
 */
public class LeetCode_236_364 {

  class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) return root;

      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      return left == null ? right : right == null ? left : root;
    }
  }
}

package Week_02.G20200343030492;

/**
 * LeetCode_236_492
 */
public class LeetCode_236_492 {

	/**
	 * 递归法，时间复杂度：O(n)，空间复杂度：O(n)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
	}

	/**
	 * 官方的递归法，时间复杂度：O(n)，空间复杂度：O(n)
	 */
	private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return this.ans;
    }

    private boolean recurse(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return false;
        int left = recurse(cur.left, p, q) ? 1 : 0;
        int right = recurse(cur.right, p, q) ? 1: 0;
        int mid = (cur == q || cur == p) ? 1 : 0;
        if (mid + right + left >= 2) {
            ans = cur;
        }
        return (mid + left + right > 0);
	}
	
	/**
	 * 整体思路：使用map保存每个节点的父节点，之后把p的所有父节点放进set中，再上溯q的父节点，当上溯到父节点在set中时，那个节点就是p和q的最近公共父节点。
	 * 时间复杂度：O(n)，空间复杂度：O(n)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Set<TreeNode> ancestors = new HashSet<>();
        Stack<TreeNode> s = new Stack<>();
        parent.put(root, null);
        s.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode tr = s.pop();
            if (tr.right != null) {
                parent.put(tr.right, tr);
                s.push(tr.right);
            }
            if (tr.left != null) {
                parent.put(tr.left, tr);
                s.push(tr.left);
            }
        }
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
	

}
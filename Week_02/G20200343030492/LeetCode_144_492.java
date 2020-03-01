package Week_02.G20200343030492;
import java.util.*;
/**
 * LeetCode_144_492
 */
public class LeetCode_144_492 {

	/**
	 * 迭代法。时间复杂度：O(n)，空间复杂度：O(n)。
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            res.add(n.val);
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);
        }
        return res;
	}
	
	/**
	 * 递归法。时间复杂度：O(n)，空间复杂度：O(n)。
	 */
	List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
	}
	
	/**
	 * 也是使用栈来递归，不过形式不太一样。
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop().right;
        }
        return res;
    }
}
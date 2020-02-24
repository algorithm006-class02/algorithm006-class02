import java.util.Stack;

/**
 * @Description：226. 翻转二叉树
 *
 *     4
/   \
2     7
/ \   / \
1   3 6   9
输出：

4
/   \
7     2
/ \   / \
9   6 3   1

 */
public class LeetCode_226_022 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return root;
    }
}

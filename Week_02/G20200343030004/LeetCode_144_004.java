import java.util.*;

public class LeetCode_144_004 {

    // 递归
    ArrayList<Integer> data = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return data;
        }
        data.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return data;
    }

    //迭代法
    public List<Integer> preorderTraversal02(TreeNode root) {
        ArrayList<Integer> data = new ArrayList<>();
        if(root == null) {
            return data;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            data.add(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return data;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

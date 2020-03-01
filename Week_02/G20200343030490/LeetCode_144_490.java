import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-23 22:08
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_144_490 {

    private List<Integer> result = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    public List<Integer> preorderTraversalLoop(TreeNode root) {
        if (root == null) {
            return result;
        }
        Stack<TreeNode> currentNodeList = new Stack<>();
        currentNodeList.push(root);

        while (!currentNodeList.isEmpty()) {
            TreeNode current = currentNodeList.pop();
            result.add(current.val);

            if(current.right != null){
                currentNodeList.push(current.right);
            }

            if(current.left != null) {
                currentNodeList.push(current.left);
            }
        }

        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

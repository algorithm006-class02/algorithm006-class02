import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

    //root -> left -> right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalByRecursion(list, root);
        return list;
    }

    public List<Integer> preorderTraversalNormal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<FlagNode> stack = new Stack<>();
        stack.push(new FlagNode(root, false));
        while (!stack.isEmpty()) {
            FlagNode fn = stack.pop();
            if (fn.visited) {
                list.add(fn.node.val);
            } else {
                //root -> left -> right
                if (fn.node.right != null) {
                    stack.push(new FlagNode(fn.node.right, false));
                }
                if (fn.node.left != null) {
                    stack.push(new FlagNode(fn.node.left, false));
                }
                stack.push(new FlagNode(fn.node, true));
            }
        }
        return list;
    }

    static class FlagNode {
        private TreeNode node;
        private Boolean visited;

        public FlagNode(TreeNode node, Boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    private void preorderTraversalByRecursion(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalByRecursion(list, root.left);
        preorderTraversalByRecursion(list, root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    
class SolutionWithStack {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output  = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        if (root == null){
            return output;
        }

        stack.add(root);
        while(stack.size() != 0){
            TreeNode n = stack.pollLast();
            output.add(n.val);

            if (n.right != null){
                stack.addLast(n.right);
            }

            if (n.left != null){
                stack.addLast(n.left);
            }
        }

        return output;
    }
}

class SolutionWithMirrors {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();

        TreeNode current = root;
        while (current != null) {
            TreeNode previous = current.left;
            if (previous != null) {
                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }

                if (previous.right == null) {
                    output.add(current.val);
                    previous.right = current;
                    current = current.left; // 下移current对象
                    continue;
                }

                if (previous.right == current) {
                    previous.right = null; // 清空链接
                }
            } else {
                output.add(current.val);
            }

            current = current.right;
        }

        return output;
    }
}

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(16);
        parentMap.put(root, null);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> pParents = new HashSet<>();
        while (p != null) {
            pParents.add(p);
            p = parentMap.get(p);
        }

        while (!pParents.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }

}
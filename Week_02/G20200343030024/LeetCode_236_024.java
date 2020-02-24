import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class TreeNode {      
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        stack.add(root);
        parent.put(root, null);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
           TreeNode node = stack.pollLast();
           
           if (node.right != null){
               parent.put(node.right, node);
               stack.add(node.right);
           }

           if (node.left != null){
               parent.put(node.left, node);
               stack.add(node.left);
           }
        }

        Set<TreeNode> pParents = new HashSet<TreeNode>();
        while(p != null){
            pParents.add(p);
            p = parent.get(p);
        }

        while(!pParents.contains(q)){
            q = parent.get(q);
        }

        return q;
    }
}
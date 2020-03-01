package G20200343030372;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen.C
 * @date 2020/2/20
 */
public class Binary_tree_preorder_traversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        recursive(root, resultList);
        return resultList;
    }

    private void recursive(TreeNode node, List<Integer> resultList){
        if(node == null){
            return;
        }
        resultList.add(node.val);
        if(node.left != null){
            this.recursive(node.left, resultList);
        }
        if(node.right != null){
            this.recursive(node.right, resultList);
        }
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

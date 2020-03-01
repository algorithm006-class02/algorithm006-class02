import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_105_590 {



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        // record the in-order items and their positions
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // dfs
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
                inorder.length - 1, inMap);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // calc the root position and divide the two arrays
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}

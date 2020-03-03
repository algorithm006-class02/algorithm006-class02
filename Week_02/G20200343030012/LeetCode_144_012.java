import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 */


// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverseNode(result, root);
        return result;
    }

    void traverseNode(List<Integer> result, TreeNode node) {

        if (node == null) { return; }

        result.add(node.val);

        traverseNode(result, node.left);
        traverseNode(result, node.right);
    }
}
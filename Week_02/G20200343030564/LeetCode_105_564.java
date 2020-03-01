package Week02;

import Week02.Entity.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode_105_564 {

    public int pre_idx = 0;

    public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // 前序遍历：根左右
    public int[] preorder;
    // 中序遍历：左根右
    public int[] inorder;

    public static void main(String[] args) {
        LeetCode_105_564 leetCode = new LeetCode_105_564();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = leetCode.buildTreeNode(preorder, inorder);
//        TreeNode treeNode = leetCode.buildTree(preorder, inorder);

    }

    /**
     * 构建链表
     * @return
     */
    public TreeNode buildTreeNode(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorder = inorder;

        // 把中序数组放入HashMap中
        for (int i = 0; i < inorder.length; i++) {
            // key : 值  ， value：数组下标
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    /**
     * 递归
     * 时间复杂度：O(n)
     *
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper(int left, int right){
        // terminal
        if (left == right) {
            return null;
        }

        // 获取preorder中的参数作为root节点
        int val = preorder[pre_idx];
        TreeNode root = new TreeNode(val);

        // 查找这个节点在inorder中的位置
        int index = map.get(val);

        // 前序节点的指针向后移动(每次循环都要移动，因为本次循环前驱节点中的值已经使用)
        pre_idx++;

        // 查找左边的节点 (会按照中序遍历找左右两个节点，放在左右位置)
        root.left = helper(left, index);

        // 查找右边的节点
        root.right = helper(index + 1, right);

        return root;
    }


//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return helper(0, 0, inorder.length - 1, preorder, inorder);
//    }
//
//    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//        if (preStart > preorder.length - 1 || inStart > inEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int inIndex = 0; // Index of current root in inorder
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == root.val) {
//                inIndex = i;
//            }
//        }
//        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
//        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
//        return root;
//    }
}

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //方法1
    //    前序遍历 是 root left right
//    可以直接找到二叉树的根节点 root 就是第一个位置
//    然后从中序inorder 中 找到这个跟root在中序中的位置
//    那么中序遍历数组的左边就是 左子树 右边就是右子树
//    然后构造出的左子树 中 进入这深入一层的 重复 步骤的划分
//    继续上述的递归重复划分知道 preinorder inorder 都为空
//            返回null即 表示到头了 遍历结束
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        //preoder空 直接返回null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        int rightNum = i_end - i_root_index;
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    //    方法2 空间换时间
    //    通过HashMap记录保存 缓存一个中序遍历的键值对
    //    目的是免去每一次茶盅中序二叉树的根 子二叉树的根的for循环遍历是时间，从而优化了性能
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_Map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right) {
            return null;
        }
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_Map.get(root_val);

        // recursion
        pre_idx++;//为的是前序遍历数组的第一个位置是root 那么++后递归的左子树的中左子树的子root根节点
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }

    // 时间复杂度O(N)
    // 空间复杂度是 HashMap存这个数组O(N)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        //build hashMap为了空间上缓存一个带索引的key-value方便查找中序遍历数组子树中
        //        的root的index 这样既不用每次都for循环遍历的重复工作了
        int idx = 0;
        for (Integer val : inorder) {
            idx_Map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }
}
// @lc code=end


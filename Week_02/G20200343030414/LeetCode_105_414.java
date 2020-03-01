package Week_02.G20200343030414;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @since 2020-02-23 17:53
 */
public class LeetCode_105_414 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 举例分析
     * 前序遍历: GDAFEMHZ
     * 中序遍历: ADEFGHMZ
     * <p>
     *     画树求法：
     *        第一步，根据前序遍历的特点，我们知道根结点为G
     *        第二步，观察中序遍历ADEFGHMZ，其中root节点G左侧的ADEF必然是root的左子树，G右侧的HMZ必然是root的右子树
     *        第三步，观察左子树ADEF，左子树的中的根节点必然是大树root的leftchild，在前序遍历中，大树的root的leftchild位于root之后，所以左子树的根节点为D
     *        第四步，同样的道理，root的右子树节点HMZ中的根节点也可以通过前序遍历求得。在前序遍历中，一定是先把root和root的所有左子树节点遍历完之后才会遍历右子树，
     *              并且遍历的左子树的第一个节点就是左子树的根节点。同理，遍历的右子树的第一个节点就是右子树的根节点
     *        第五步，观察发现，上面的过程是递归的。先找到当前树的根节点，然后划分为左子树，右子树，然后进入左子树重复上面的过程，然后进入右子树重复上面的过程。最后就可以还原一棵树了
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd,
                              Map<Integer, Integer> inMap) {
        // 终止条件
        if (preStart > preEnd || inStart > inEnd) return null;
        // 处理当前层逻辑
        TreeNode root = new TreeNode(preorder[preStart]); // 根据上面第一步确定
        int rootOffset = inMap.get(root.val); // 从 inMap 缓存中获取到根节点的偏移位置
        int leftOffset = rootOffset - inStart; // 左子树最大的偏移位置
        // 进入下一层：把左子树当作一棵单独的树开始构建
        root.left = buildTree(preorder, preStart + 1, preStart + leftOffset,
                inorder, inStart, rootOffset - 1, inMap);
        // 进入下一层：把右子树当作一棵单独的树开始构建
        root.right = buildTree(preorder, preStart + leftOffset + 1, preEnd,
                inorder, rootOffset + 1, inEnd, inMap);
        return root;
    }

}

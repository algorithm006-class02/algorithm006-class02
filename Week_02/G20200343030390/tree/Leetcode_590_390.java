/**
 *
 * 590.N 叉树的后序遍历
 *   左-右-根
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树（图片参考）
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 *
 * 思路（精简）：
 * 1.递归
 *
 * 2.迭代
 *
 *
 */
public class Leetcode_590_390 {

    /**
     * 1.递归
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;

        for(Node node: root.children)
            postorder(node);

        list.add(root.val);

        return list;
    }
}

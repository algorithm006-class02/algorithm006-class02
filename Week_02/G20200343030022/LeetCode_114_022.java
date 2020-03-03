import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description：
 * 给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [1,2,3]

 */
public class LeetCode_114_022 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description：
 *
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [1,3,2]
 */
public class LeetCode_94_022 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        helper(res,root);
        return res;
    }
    public void helper(List<Integer> res, TreeNode root){
        if(root != null){
            if(root.left != null)
                helper(res, root.left);
            res.add(root.val);
            if(root.right != null)
                helper(res, root.right);
        }
    }


    /**
     * 方法二是用stack来模拟虚拟机的栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;

        }
        return res;
    }
}

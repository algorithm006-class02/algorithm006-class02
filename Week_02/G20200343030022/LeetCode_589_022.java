import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 20:54 2020/2/20
 * @Description：589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

返回其前序遍历: [1,3,5,6,2,4]。
 */
public class LeetCode_589_022 {

    /**
     * 递归的思想
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        helper(res,root);
        return res;
    }

    public void helper(List<Integer> res , Node root){
        if(root == null){
            return;
        }
        res.add(root.val);
        for(Node node : root.children){
            helper(res, node);
        }

    }

    /**
     *  就是用stack的方法来做 bfs的方法
     *
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Integer> res = new LinkedList();
        if(root == null) return res;
        LinkedList<Node> stack = new LinkedList();
        stack.add(root);
        while(!stack.isEmpty()){

            Node cur = stack.pollLast();
            res.add(cur.val);
            int len = cur.children.size();
            for(int i = len -1;i >= 0;i--){
                stack.add(cur.children.get(i));
            }
        }
        return res;
    }
}

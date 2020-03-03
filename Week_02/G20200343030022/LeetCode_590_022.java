import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 20:37 2020/2/20
 * @Description：590. N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :
返回其后序遍历: [5,6,3,2,4,1].
 */
public class LeetCode_590_022 {

    /**
     * 第一种想法通过 bfs来做宽度遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList();
        if(root == null) return res;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            res.addFirst(cur.val);
            for(Node node : cur.children){
                stack.push(node);
            }
        }
        return res;


    }

    /**
     * 第二种递归的思想
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList();
        helper(res,root);
        return res;
    }

    public void helper(List<Integer> res , Node root){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            helper(res, node);
        }
        res.add(root.val);
    }
}

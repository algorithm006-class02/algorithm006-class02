import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 21:43 2020/2/20
 * @Description：429. N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
返回其层序遍历:

[
[1],
[3,2,4],
[5,6]
]
 */
public class LeetCode_429_022 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        LinkedList<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new LinkedList();
            int s = queue.size();
            for(int i = 0 ; i < s;i++){
                Node cur = queue.get(0);
                queue.remove(0);
                level.add(cur.val);
                queue.addAll(cur.children);
            }
            res.add(level);
        }
        return res;
    }


    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

}

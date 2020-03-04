import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ：zhenghaoran.
 * @Description：515. 在每个树行中找最大值
 */
public class LeetCode_515_022 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int largest = Integer.MIN_VALUE;
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                largest = Math.max(largest, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

            }
            res.add(largest);
        }
        return res;

    }
}

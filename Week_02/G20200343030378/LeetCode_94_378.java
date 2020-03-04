import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_378 {
    //递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == list || list.size() == 0)
            return list;
        helper(root,list);
        return list;
    }
    private void helper(TreeNode root, List<Integer> list){
        if (null != root.left)
            helper(root.left,list);
        if (null != root)
            list.add(root.val);
        if (null != root.right)
            helper(root.right,list);
    }

}

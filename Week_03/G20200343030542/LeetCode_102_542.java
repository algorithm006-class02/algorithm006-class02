

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize =  queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                TreeNode cn = queue.poll();
                list.add(cn.val);
                if(cn.left != null){
                    queue.offer(cn.left);
                }
                if(cn.right != null){
                    queue.offer(cn.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
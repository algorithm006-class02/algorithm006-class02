class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        while(!Q.isEmpty()){
            int size = Q.size();
            List<Integer> r1 = new ArrayList<Integer>();
            for (int i = 0; i < size; i++){
                TreeNode node = Q.poll();
                r1.add(node.val);
                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
            if (r1.size() > 0) result.add(r1);
        }

        return result;
    }
}
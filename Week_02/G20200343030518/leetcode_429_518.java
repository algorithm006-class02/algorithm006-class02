public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new LinkedList<>();
    if (root == null) return list;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
        while (!queue.isEmpty()) {
        List<Integer> curLevel = new LinkedList<>();
        int len = queue.size();
           for (int i = 0; i < len; i++) {
                 Node curr = queue.poll();
                   curLevel.add(curr.val);
                   for (Node c : curr.children)
                    queue.offer(c);
        }
        list.add(curLevel);
        }
        return list;
}
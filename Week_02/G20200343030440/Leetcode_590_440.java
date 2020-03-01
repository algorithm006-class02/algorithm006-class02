class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
    if(root == null)
        return list;
    Stack<Node> s1 = new Stack<>();
    s1.add(root);
    while(!s1.isEmpty()){
        Node cur = s1.pop();
        list.add(0,cur.val);
        for(Node children : cur.children){
            s1.add(children);
        }
    }
    return list;
    }
}

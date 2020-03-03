/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
       List<Integer> result = new ArrayList<>();
       helper(root,result);
       return result;
    }
    private void helper(Node root, List<Integer> result){
        if (root != null){
            for(int i=0; i<root.children.size();i++){
                if (root.children.get(i) != null){
                    helper(root.children.get(i),result);
                }
            }
            result.add(root.val);
        }
    }
}
public class LeetCode_493_590 {

    public int reversePairs(int[] nums) {
        Node root = null;
        int[] cnt = new int[1];
        for(int i = nums.length-1; i>=0; i--){
            search(cnt, root, nums[i]/2.0);//search and count the partially built tree
            root = build(nums[i], root);//add nums[i] to BST
        }
        return cnt[0];
    }

    private void search(int[] cnt, Node node, double target){
        if(node==null) return;
        else if(target == node.val) cnt[0] += node.less;
        else if(target < node.val) search(cnt, node.left, target);
        else{
            cnt[0]+=node.less + node.same;
            search(cnt, node.right, target);
        }
    }

    private Node build(int val, Node n){
        if(n==null) return new Node(val);
        else if(val == n.val) n.same+=1;
        else if(val > n.val) n.right = build(val, n.right);
        else{
            n.less += 1;
            n.left = build(val, n.left);
        }
        return n;
    }

    class Node{
        int val, less = 0, same = 1;//less: number of nodes that less than this node.val
        Node left, right;
        public Node(int v){
            this.val = v;
        }
    }
}

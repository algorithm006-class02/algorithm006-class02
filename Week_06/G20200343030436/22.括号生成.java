import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        generateOnebyOne("", result, n, n);
        return result;
    }

    public void generateOnebyOne(String sublist,List<String> result,
        int left, int right){
            if(left == 0 && right == 0) {
                result.add(sublist);
                return;
            }
            if(left > 0) {
                generateOnebyOne(sublist + "(", result, left - 1, right);
            }
            if(right > left) {
                generateOnebyOne(sublist + ")", result, left, right - 1);
            }
    }

    class Node{
        private String res;
        private int left;
        private int right;
        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                result.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return result;
    }
}
// @lc code=end


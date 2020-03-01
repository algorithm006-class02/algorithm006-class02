import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private int k;
    private int n;
    private List<List<Integer>> output;
    
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.output = new ArrayList<List<Integer>>();
        helper(1, n + 1, new LinkedList<Integer>());
  
        return output;
    }
  
    public void helper(int start, int end, LinkedList<Integer> curr){
        if (curr.size() ==  k){
            output.add(new ArrayList<Integer>(curr));
            return;
        }
  
        for (int i = start; i < end; i++){
            curr.add(i);
            helper(i + 1, end, curr);
            curr.removeLast();
        }
  
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> output = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new LinkedList<Integer>(), new LinkedList<Integer>());
        return output;    
    }

    public void helper(int[] nums, LinkedList<Integer> current, LinkedList<Integer> arr){
        if (current.size() == nums.length){
            output.add(new ArrayList(current));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (arr.contains(i)){
                continue;
            }
            current.add(nums[i]);
            arr.add(i);
            helper(nums, current, arr);
            current.removeLast();
            arr.removeLast();
        }
    }
}
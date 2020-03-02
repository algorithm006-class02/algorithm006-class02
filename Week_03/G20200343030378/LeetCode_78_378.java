import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_378 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(0,nums,ret,new ArrayList<Integer>());
        return ret;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> ret, ArrayList<Integer> tmp) {
        //termination
        if(i > nums.length)
            return;
        //process
        ret.add(new ArrayList<>(tmp));
        //down
        for (int j = i; j < nums.length;j++){
            tmp.add(nums[j]);
            //.......
            backtrack(i+1,nums,ret,tmp);
            //resize
            tmp.remove(tmp.size()-1);
        }
    }

}

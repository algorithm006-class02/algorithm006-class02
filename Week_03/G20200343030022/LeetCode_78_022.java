import java.util.ArrayList;
import java.util.List;

/**
 * @Description：78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
[3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class LeetCode_78_022 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        if(nums == null) return out;
        recursion(0, nums,new ArrayList(),out);
        return out;
    }

    public void recursion(int level,int[] nums,List<Integer> list,List<List<Integer>> ans){
        if(level == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        recursion(level+1,nums,list,ans);
        list.add(nums[level]);
        recursion(level+1,nums,list,ans);
        list.remove(list.size()-1);
    }

}

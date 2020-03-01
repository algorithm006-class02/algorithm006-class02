package Week_02.G20200343030492;

/**
 * LeetCode_46_492
 */
public class LeetCode_46_492 {

	/**
	 * 回溯法
	 */
	public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) {
            list.add(n);
        }
        List<List<Integer>> output = new ArrayList<>();
        backtrack(0, output, list, nums.length);
        return output;
    }

    private void backtrack(int first, List<List<Integer>> output, List<Integer> nums, int n) {
        if (first == n) output.add(new ArrayList<>(nums));
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(first + 1, output, nums, n);
            Collections.swap(nums, first, i);
        }
	}
	
	/**
	 * 插入法，假如有nums=[1,2,3],假设一开始有空数组[]，要逐个把nums的数插入到数组中。首先，把1插入到数组中，得到[1]，再把2插入到数组
	 * 中，插入的位置可以是0或1，于是得到[[1,2],[2,1]]，同理，3也是一样。
	 */
	public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> output = new ArrayList<>();
        output.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List l : output) {
                for (int j = 0; j <= i; j++) {
                    List<Integer> newList = new ArrayList<>(l);
                    newList.add(j, nums[i]);
                    tmp.add(newList);
                }
            }
            output = tmp;
        }
        return output;
    }
}
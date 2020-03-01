class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<Integer>();
        //排序
        Arrays.sort(nums);
        // 0代表数组索引开始
        backtracking(list, new ArrayList<>(), 0, nums);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> tmpList, int start, int[] nums) {
        list.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) { //遍历nums
            tmpList.add(nums[i]); //
            backtracking(list, tmpList, i + 1, nums);//每层的元素 选择、不选择两种
            tmpList.remove(tmpList.size() - 1);//回溯
        }
    }
}
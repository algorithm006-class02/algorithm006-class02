class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tmp = generate(result, nums[i]);
            result.clear();
            result.addAll(tmp);
        }
        return result;
    }

    private List<List<Integer>> generate(List<List<Integer>> list, int num) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : list) {
            for (int i = 0; i < l.size() + 1; i++) {
                List<Integer> tmp = new ArrayList<>(l);
                tmp.add(i, num);
                result.add(tmp);
            }
        }
        return result;
    }
}

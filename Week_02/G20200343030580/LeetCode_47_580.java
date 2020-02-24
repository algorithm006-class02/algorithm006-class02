class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<List<Integer>> set = new HashSet();
        for (List<Integer> l : list) {
            for (int i = 0; i < l.size() + 1; i++) {
                List<Integer> tmp = new ArrayList<>(l);
                if (i == l.size() || l.get(i) != num) {
                    tmp.add(i, num);
                    set.add(tmp);
                } else {
                    continue;
                }
            }
        }
        return new ArrayList<>(set);
    }
}

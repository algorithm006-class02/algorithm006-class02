class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        List<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            numList.add(num);
            
        }
        List<Integer> resultList = new ArrayList<>();

        helper(numList, resultList);
        return result;

    }

    private void helper(List<Integer> numList, List<Integer> resultList) {
        if (numList.size() == 0) {
            result.add(new ArrayList<>(resultList));
            return;     
        }
        for (int i = 0; i < numList.size(); i++) {
            if (i > 0 && numList.get(i) == numList.get(i - 1)) {
                continue;
            }
            resultList.add(numList.get(i));
            List<Integer> next = new ArrayList<>(numList);
            // 注意此处，不断向后移缩短备选list，避免重复
            next.remove(i);
            helper(next, resultList);
            resultList.remove(resultList.size() - 1);
        }
    }
}

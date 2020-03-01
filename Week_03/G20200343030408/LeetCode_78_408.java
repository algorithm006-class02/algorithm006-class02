class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        helper(result,nums,new ArrayList<Integer>(), 0);
        return result;
    }
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        //terminator
        if (index == nums.length){ //index:layer touch the end layer
            result.add(new ArrayList<Integer>(list)); //add your result to the final result list
            return;
        }
        //current logic
        helper(result,nums,list,index+1); // not pick the number at this index(not make any change to the list)
        
        list.add(nums[index]); // pick the number at this index(pass the number to this temp list)
        helper(result,nums,list,index+1);
        // reverse the current state
        list.remove(list.size()-1); //remove item in a given index
    }
}

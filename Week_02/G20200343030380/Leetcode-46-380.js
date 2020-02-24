/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let output = [];
  
  function backtrack(first){
      // if all integers are used up
      // use distructure operator to clone 'nums' value and save to 'result'
      if(first === nums.length) output.push([...nums]);
      
      // we iterate over the indexes i from 'first' to the length
      // of the entire sequence 'nums'
      for(let i = first; i < nums.length; i++){
          // place i-th integer first
          // in the current permutation
          [nums[first], nums[i]] = [nums[i], nums[first]];
          
          // use next integers to complete the permutations
          backtrack(first + 1);
          
          // backtrack
          [nums[first], nums[i]] = [nums[i], nums[first]];
      }      
  }
  
  backtrack(0);
  return output;
};




// Python DFS
//def permute(self, nums):
//    res = []
//    self.dfs(nums, [], res)
//    return res
//    
//def dfs(self, nums, path, res):
//    if not nums:
//        res.append(path)
//        # return # backtracking
//    for i in xrange(len(nums)):
//        self.dfs(nums[:i]+nums[i+1:], path+[nums[i]], res)
/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * Example:
    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
 * @param {number[]} nums
 * @return {number[][]}
 */
// 方法一： 回溯法
const permute = (nums) => {
  let result = []  
  backtrack(result, [], nums)
  return result
};

const backtrack = (result, tempList, nums) => {
  if (tempList.length === nums.length) return result.push([...tempList]) 
  for (let i = 0; i < nums.length; i++) {
    if (tempList.includes(nums[i])) continue
    tempList.push(nums[i])
    backtrack(result, tempList, nums)
    tempList.pop()
  }
}

/*
tempList:
[]
[1]
  [1,2]
    [1,2,3] => result = [[1,2,3]]
  [1,3]
    [1,3,2] => result = [[1,2,3],[1,3,2]]
[2]
  [2,1]
   [2,1,3] => ... 
  [2,3]
    [2,3,1] => ...
[3]
  [3,1]
    [3,1,2] => ...
  [3,2]
    [3,2,1] => ...
*/
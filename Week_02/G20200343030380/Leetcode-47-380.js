/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 * Example:
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
 * @param {number[]} nums
 * @return {number[][]}
 */
const permuteUnique = (nums) => {
  const result = []
  backtracking(result, nums.sort((a,b)=> a-b))
  return result
};

const backtracking = (result, nums, tempList = [], visited = []) => {
  if (tempList.length === nums.length) return result.push([...tempList])
  for (let i = 0; i < nums.length; i++) {
    if (visited[i]) continue
    if (i > 0 && nums[i] === nums[i-1] && visited[i-1]) continue

    visited[i] = true
    tempList.push(nums[i])
    backtracking(result, nums, tempList, visited)
    visited[i] = false
    tempList.pop()
  }
};
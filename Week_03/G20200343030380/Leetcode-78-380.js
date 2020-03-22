/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * @param {number[]} nums
 * @return {number[][]}
 */
// 方法一：回溯
const subsets = (nums) => {
  let result = []
  backtrack(result, nums, [], 0)
  return result
}

const backtrack = (result, nums, tempList, start) => {
  result.push([...tempList])
  for (let i = start; i < nums.length; i++) {
    tempList.push(nums[i])
    backtrack(result, nums, tempList, i+1)
    tempList.pop()
  }
}
//}
//for i = 0
//  tempList = [1]
//    backtrack-1  for i = 1 
//      tempList = [1,2]
//        backtrack-2 for i = 2 
//          templist = [1,2,3]
//            backtrack-3 for exceed
//          tempList = [1,2]
//        backtrack-2 for i++ exceed
//      tempList = [1]
//    backtrack-1 for i = 2
//      tempList = [1,3]
/*
 * []
 * [1]
 * [1,2]
 * [1,2,3]
 * [1,3]
 * [2]
 * [2,3]
 * [3]
 */    
// https://leetcode-cn.com/problems/permutations/
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  return backtrack(nums)
  function backtrack(nums, step = 0, res = []) {
    if (step === nums.length) {
      res.push([...nums])
      return
    }
    for (let i = step; i < nums.length; ++i) {
      swap(nums, i, step)
      backtrack(nums, step + 1, res)
      swap(nums, i, step)
    }
    return res
  }
  function swap(nums, i, j) {
    const temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
  }
};

var permute_1 = function (nums) {
  const visited = []
  let item = []
  return backtrace(nums)
  function backtrace(nums, step = 0, res = []) {
    if (step === nums.length) {
      res.push([...item])
      return
    }
    for (let i = 0; i < nums.length; ++i) {
      if (!visited[i]) {
        item.push(nums[i])
        visited[i] = 1
        backtrace(nums, step + 1, res)
        visited[i] = 0
        item.pop()
      }
    }
    return res
  }
}


var permute_1_1 = function (nums) {
  return backtrace(nums)
  function backtrace(nums, step = 0, visited = [], item = [], res = []) {
    if (step === nums.length) {
      res.push(item)
      return
    }
    for (let i = 0; i < nums.length; ++i) {
      if (!visited[i]) {
        const newItem = [...item]
        newItem.push(nums[i])
        const newVisited = [...visited] 
        newVisited[i] = 1
        backtrace(nums, step + 1, newVisited, newItem, res)
      }
    }
    return res
  }
}

var permute_2 = function(nums) {
  let ans = []
  if (nums.length === 0) return ans

  ans.push([nums[0]])
  for (let i = 1; i < nums.length; ++i) {
    const temps = []
    for (let j = 0; j <= i; ++j) {
      for (let x of ans) {
        const temp = [...x]
        temp.splice(j, 0, nums[i])
        temps.push(temp)
      }
    }
    ans = temps
  }
  return ans
}

var permute_3 = function(nums) {
  let result = [[nums[0]]]
  for (let i = 1; i < nums.length; ++i) {
    const len = result.length
    const temps = []
    for (let j = 0; j < len; ++j) {
      const item = result[j]
      for (let k = 0; k <= result[j].length; ++k) {
        const temp = [...item]
        temp.splice(k, 0, nums[i])
        temps.push(temp)
      }
    }
    result = temps
  }
  return result
}

// console.log(permute([1, 2, 3]))
// console.log(permute_1([1, 2, 3]))
// console.log(permute_2([1, 2, 3, 4]))
// console.log(permute_3([1, 2, 3]))
console.log(permute_1_1([1, 2, 3]))
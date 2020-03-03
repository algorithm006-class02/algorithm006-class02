// https://leetcode-cn.com/problems/permutations-ii/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  if (nums.length === 0) return []

  let result = [[nums[0]]]
  for (let i = 1; i < nums.length; ++i) {
    const len = result.length;
    const temps = []
    for (let j = 0; j < len; ++j) {
      const item = result[j]
      for (let k = 0; k <= item.length; ++k) {
        if (item[k] === nums[i]) {
          continue
        }
        const temp = [...item]
        temp.splice(k, 0, nums[i])
        temps.push(temp)
      }
    }
    result = temps
  }
  const map = new Map()
  for (let i = 0; i < result.length; ++i) {
    const key = result[i].join()
    if (!map.has(key)) {
      map.set(key, result[i])
    }
  }
  return [...map.values()]
};


var permuteUnique_1 = function(nums) {
  if (nums.length === 0) return []
  nums.sort()
  return backtrace(nums)
  function backtrace(nums, step = 0, visited = [], item = [], res = []) {
    if (step === nums.length) {
      res.push([...item])
      return
    }
    for (let i = 0; i < nums.length; ++i) {
      if (!visited[i]) {
        if (i > 0 && nums[i] === nums[i - 1] && !visited[i - 1]) continue
        item.push(nums[i])
        visited[i] = 1
        backtrace(nums, step + 1, visited, item, res)
        visited[i] = 0
        item.pop()
      }
    }
    return res
  }
}

// console.log(permuteUnique([1, 1, 2, 1]))
console.log(permuteUnique_1_1([2, 2, 1, 1]))
// console.log(permuteUnique_1([2, 2, 1, 1]))

/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  // 排序后，下标n/2的元素必定是多数元素
  const sort = nums => {
    nums.sort((a, b) => a - b)
    return nums[Math.floor(nums.length / 2)]
  }

  const mapCount = nums => {
    let map = {}
    let half = Math.floor(nums.length / 2)
    for (let i = 0; i < nums.length; i++) {
      if (map[nums[i]]) {
        if (map[nums[i]] === half) return nums[i]
        map[nums[i]]++
      } else {
        map[nums[i]] = 1
      }
    }
    return nums[0]
  }

  return sort(nums)
  // return mapCount(nums)
};
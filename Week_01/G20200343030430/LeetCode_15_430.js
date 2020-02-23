/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  if (!nums || nums.length < 3) return []

  // 排序 双指针
  nums.sort((a, b) => a - b)
  let len = nums.length
  let res = []
  for (let i = 0; i < len; i++) {
    if (nums[i] > 0) break
    // 重复元素已处理过则跳过
    if (i > 0 && nums[i - 1] == nums[i]) continue

    let l = i + 1
    let r = len - 1
    while (l < r) {
      let sum = nums[i] + nums[l] + nums[r]
      if (sum == 0) {
        res.push([nums[i], nums[l], nums[r]])
        // 指针指向下一个非重复元素
        while (l < r && nums[l + 1] == nums[l]) l++
        while (l < r && nums[r - 1] == nums[r]) r--
        l++
        r--
      } else if (sum < 0) {
        l++
      } else if (sum > 0) {
        r--
      }
    }
  }

  return res
};
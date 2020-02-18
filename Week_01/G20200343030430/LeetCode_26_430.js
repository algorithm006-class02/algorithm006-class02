/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  if (nums.length < 2) return nums.length
  var pos = 0
  for (var i = 1; i < nums.length; i++) {
    if (nums[pos] !== nums[i]) {
      nums[++pos] = nums[i]
    }
  }
  return pos + 1
};
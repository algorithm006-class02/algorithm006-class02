/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
  if (nums.length < 2 || k % nums.length == 0) return
  var temp, previous
  k %= nums.length
  for (var i = 0; i < k; i++) {
    previous = nums[nums.length - 1];
    for (var j = 0; j < nums.length; j++) {
      temp = nums[j]
      nums[j] = previous
      previous = temp
    }
  }
};
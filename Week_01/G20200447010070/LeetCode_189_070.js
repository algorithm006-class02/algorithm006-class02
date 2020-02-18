/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

// @lc code=start
/**
 * 使用多指针
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  let count = 0; // 已经替换的数据个数
  let start = 0; // 记录每次替换的开始值
  while (count < nums.length) {
    let curr = start;
    let prevNum = nums[start]; // 记录被替换的数据
    do {
      // 要替换的位置
      let next = (curr + k) % nums.length;
      let tmp = nums[next];
      nums[next] = prevNum;
      prevNum = tmp;
      curr = next;
      count++;
    } while (curr != start);
    start++; // 当旋转次数是数组的一半时，就需要
  }
};

/**
 * 使用数组反转
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate2 = function(nums, k) {
  k %= nums.length; // 旋转 n 次相当于没有旋转

  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);

  function reverse(nums, start, end) {
    while (start < end) {
      let tmp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = tmp;
    }
  }
};
// @lc code=end

/**
 * 493. Reverse Pairs
 * https://leetcode-cn.com/problems/reverse-pairs/
 * @param {number[]} nums
 * @return {number}
 */
// 归并排序
const reversePairs = (nums) => {
  if (!nums || !nums.length) return 0
  return mergeSort(nums, 0, nums.length-1)
}

const mergeSort = (nums, left, right) => {
  if (left >= right) return 0
  let mid = (left + right) >> 1
  let result = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right)
  result += merge(nums, left, mid, right)
  return result
}

const merge = (nums, left, mid, right) => {
  let i = left, j = mid + 1, c = 0, arr = [], count = 0, t = left
  for (; j <= right; j++) {
    while(i <= mid && nums[i] <= nums[j]) arr[c++] = nums[i++]
    while(t <= mid && nums[t] <= 2 * nums[j]) t++
    count += mid - t + 1
    arr[c++] =nums[j]
  }
  while(i <= mid) arr[c++] = nums[i++]
  for (let i = 0; i < arr.length; i++) {
    nums[left+i] = arr[i]
  }
  return count
}
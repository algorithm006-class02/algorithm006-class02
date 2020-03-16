/**
 * 随堂作业：使用二分查找法找出有序数组断点位置 O(logn)
 * example1: [4,5,6,7,0,1,2] => 4
 * example2: [2,1,0,7,6,5] => 3 
 */
// 思路：如果中间值比右边界值大，说明拐点出现在后半部分，否则在左半部分
const search = (nums) => {
  let left = 0, right = nums.length-1
  while (left < right) {
    let mid = Math.floor((left + right) / 2)
    if (nums[mid] > nums[right]) left = mid + 1
    else right = mid
  }
  return left
}
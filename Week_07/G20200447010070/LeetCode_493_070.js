/*
 * @lc app=leetcode.cn id=493 lang=javascript
 *
 * [493] 翻转对
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function(nums) {
  let count = 0;
  void (function mergeSort(arr, start, end) {
    if (start >= end) {
      return;
    }
    let mid = ((end - start) >> 1) + start;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);
  })(nums, 0, nums.length - 1);

  function merge(arr, start, mid, end) {
    let i = start;
    let j = mid + 1;
    // count
    while (i <= mid && j <= end) {
      if (arr[i] / 2 > arr[j]) {
        count += mid - i + 1;
        j++;
      } else {
        i++;
      }
    }

    // merge
    i = start;
    j = mid + 1;
    let k = 0;
    let temp = new Array(end - start + 1).fill(0);
    while (i <= mid && j <= end) {
      temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= end) temp[k++] = arr[j++];
    for (let p = 0; p < temp.length; p++) {
      arr[start + p] = temp[p];
    }
  }
  return count;
};
// @lc code=end

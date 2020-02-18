/**
 * 26. Remove Duplicates from Sorted Array
 */

#include <stdio.h>

//时间复杂度O(numsSize)
int removeDuplicates(int* nums, int numsSize) {
  int count = 0;  //数值重复的数量

  for (int i = 1; i < numsSize; i++) {
    if (nums[i] == nums[i - 1]) {
      count++;
    } else {
      nums[i - count] = nums[i];
    }
  }

  return numsSize - count;
}
/**
 * 移除数组中的重复项
 */

var nums = [1,1,2,3,4,4,5]
var removeDulicates = function (nums) {
  if (nums.length == 0) return;
  var i = 0;
  for (var j = 1; j < nums.length; j++ ) {
    if (nums[j] != nums[i]) {
      i++;
      nums[i] = nums[j];
    }
  }
  return i + 1;
}

var len = removeDulicates(nums);
console.log("移除重复项之后数组长度",len);
/**
 * 4种解法
 * 1、暴力 直接移动数组的每一位
 * 2、重新创建数组
 * 3、环状替换
 * 4、多次反转数组
 */
var nums1 = [1, 2, 3, 4, 5, 6];
var k1 = 3;
var rotate1 = function (nums, k) {
  var previous, temp;
  for (var i = 0; i < k; i++) {
    previous = nums[nums.length - 1];
    for (var j = 0; j < nums.length; j++) {
      temp = nums[j];
      nums[j] = previous;
      previous = temp;
    }
  }
}
rotate1(nums1, k1);
console.log("暴力法输出结果", nums1);
console.log("时间复杂度O(n*k)");
console.log("空间负责度O(1)");


var nums2 = [1, 2, 3, 4, 5, 6];
var k2 = 2;
var rotate2 = function (nums, k) {
  var newArr = [];
  for (var i = 0; i < nums.length; i++) {
    newArr[(i + k) % nums.length] = nums[i];
  }
  for (var j = 0; j < nums.length; j++) {
    nums[j] = newArr[j];
  }
}
rotate2(nums2, k2);
console.log('第二种新建数组输出结果', nums2);
console.log('时间复杂度O(n)');
console.log('空间复杂度O(n)');


var nums3 = [1, 2, 3, 4, 5, 6];
var k3 = 3;
var rotate3 = function (nums, k) {
  var count = 0;
  k %= nums.length;
  for (var start = 0; count < nums.length; start++) {
    var current = start;
    var pre = nums[start];
    do {
      var next = (current + k) % nums.length;
      var temp = nums[next];
      nums[next] = pre;
      pre = temp;
      current = next;
      count++;
    } while (start != current)
  }
}
rotate3(nums3, k3);
console.log("环状替换", nums3);
console.log('时间复杂度O(n)');
console.log('空间复杂度O(1)');


var nums4 = [1, 2, 3, 4, 5, 6];
var k4 = 3;
var rotate4 = function (nums, k) {
  k %= nums.length;
  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);
}
var reverse = function (nums, start, end) {
  while (start < end) {
    var temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
    start++;
    end--;
  }
}
rotate4(nums4, k4);
console.log("多次反转数组", nums4);
console.log("时间复杂度O(n)");
console.log("空间复杂度O(1)");
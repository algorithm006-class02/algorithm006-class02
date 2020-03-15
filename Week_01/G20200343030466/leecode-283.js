/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  // console.log('aaa',nums);
   let zeros = 0;
   let i=0;
   for(;i< nums.length;i++) {
       if(nums[i] != 0) {
           let temp = nums[zeros];
           nums[zeros] = nums[i];
           nums[i] = temp;
           ++ zeros;
       }
   }
};

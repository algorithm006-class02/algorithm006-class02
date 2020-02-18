/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums=[], target=0) {
    const _nums = nums.map((v, i)=>({
        index: i,
        value: v
    }));
    _nums.sort((a, b) => a.value - b.value);
    let i = 0,
        j = _nums.length - 1;
    while (i < j) {
        const r = _nums[i].value + _nums[j].value;
        if (r === target) break;
        if ( r > target ) {
            j--;
            continue;
        }
        if ( r < target ) {
            i++;
            continue;
        }
    }
    return [_nums[i].index, _nums[j].index];
};
// @lc code=end


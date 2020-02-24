/**
 * 俩数之和
 */
function twoSum (nums, target) {
    let hash = {};

    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (complement in hash) {
            return [hash[complement], i];
        }
        hash[nums[i]] = i;
    }
    return null;
}

let nums = [2, 7, 3, 1];
let target = 9;
let res = twoSum(nums, target);
console.log(res);

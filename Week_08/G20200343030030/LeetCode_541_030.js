/*
 * @lc app=leetcode.cn id=541 lang=javascript
 *
 * [541] 反转字符串 II
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    let len = s.length;
    let arr = s.split('');
    for (let start = 0; start < len; start += 2 * k) {
        let i = start,
            j = Math.min(start + k - 1,len - 1);
        while (i < j) {
            let temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
    return arr.join('');
};
// @lc code=end


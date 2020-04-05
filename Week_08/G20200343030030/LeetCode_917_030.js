/*
 * @lc app=leetcode.cn id=917 lang=javascript
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
/**
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function(S) {
    let chars = S.split('');
    let start = 0,
        end = S.length - 1,
        temp = '';
    while (start < end) {
        if (!/([a-z]|[A-Z])+/.test(chars[start])) {
            start++;
            continue;
        }
        if (!/([a-z]|[A-Z])+/.test(chars[end])) {
            end--;
            continue;
        }
        temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        start++;
        end--;
    }
    return chars.join('');
};
// @lc code=end


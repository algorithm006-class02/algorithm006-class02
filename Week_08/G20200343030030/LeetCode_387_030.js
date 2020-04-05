/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
/*
var firstUniqChar = function(s) {
   let hash = {};
   let result = new Map();
   for (let i = 0; i < s.length; i++) {
       if (!hash[s[i]]) {
           hash[s[i]] = 1;
           result.set(s[i],i);
       }else {
           result.delete(s[i]);
       } 
   }
   if (result.size == 0) {
       return -1;
   }
   return result.values().next().value;
};
*/
var firstUniqChar = function(s) {
    let hash = {};
    for (let i = 0; i < s.length; i++) {
        if (!hash[s[i]]) {
            hash[s[i]] = 1;
        }else {
            hash[s[i]]++;
        }
    }
    for (let j = 0; j < s.length; j++) {
       if (hash[s[j]] == 1) {
           return j;
       }
    }
    return -1;
}
// @lc code=end


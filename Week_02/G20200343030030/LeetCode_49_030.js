/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let res = {};
	for(let i = 0; i < strs.length; i++) {
		const str = strs[i]
		const hash = str.split('').reduce((sum, s)=>{
			return sum * [3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103 ][s.charCodeAt(0) - 97]
		}, 1)
		res[hash] ? res[hash].push(str) : res[hash] = [str]
	}
	
	return Object.values(res)
};
// @lc code=end


/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * @param {string[]} strs
 * @return {string[][]}
 */
// 方法一：HashTable 遍历数组，将每个元素进行排序，哈希表的 key 记录排序后的字符串，哈希表的值记录原元素，最后输出 values 即可
var groupAnagrams = function(strs) {
  let result = {}
  for (let i = 0; i < strs.length; i++) {
    let sortedStr = strs[i].split('').sort().join('') 
    if (result[sortedStr]) {
      result[sortedStr].push(strs[i])
    } else {
      result[sortedStr] = [strs[i]]
    }
  }    
  return Object.values(result)
};
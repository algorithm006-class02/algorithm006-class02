/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

// 1. 暴力法：sort一下，看两数组是否相等 O(nlogn)
// const isAnagram = (s, t) => {
//  return s.split('').sort().join('') == s.split('').sort().join('')
// }

// 2. HashTable O(n)
// 遍历数组一，用哈希表记录每个字符出现的次数，再遍历数组二，减掉每个字符出现的次数及清除key，最后如果空对象，即是Anagram
const isAnagram = (s, t) => {
  let table = {}
  for (let i = 0; i < s.length; i++) {
    table[s[i]] ? table[s[i]] += 1 : table[s[i]] = 1
  }
  
  for (let i = 0; i < t.length; i++) {
    if (table[t[i]]) {
      table[t[i]] -= 1
      if (table[t[i]] == 0) delete(table[t[i]])
    } else return false
  }
  
  return Object.keys(table) == 0 
} 

// 3. HashTable O(n)
// 使用 Javascript Map Object
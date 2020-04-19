/**
 * 242. Valid Anagram
 * https://leetcode-cn.com/problems/valid-anagram/
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 1. 暴力法：sort一下，看两数组是否相等 O(nlogn)
const isAnagram = (s, t) => {
  return s.split('').sort().join('') == s.split('').sort().join('')
}

// 2. HashTable: 遍历数组一，用哈希表记录每个字符出现的次数，再遍历数组二，减掉每个字符出现的次数，最后如果次数都是0，即是Anagram
const isAnagram = (s, t) => {
  let table = {}
  for (let i = 0; i < s.length; i++) {
    table[s[i]] = table[s[i]] ? table[s[i]] + 1 : 1
  }
  for (let i = 0; i < t.length; i++) {
    if (table[t[i]]) {
      table[t[i]] -= 1
      if (table[t[i]] == 0) delete(table[t[i]])
    } else return false
  }
  return Object.keys(table) == 0 
} 

// 3. Map
const isAnagram = (s, t) => {
  let map = new Map()
  for (let i = 0; i < s.length; ++i) { 
    map.set(s[i], map.get(s[i]) ? map.get(s[i]) + 1 : 1)
  }
  for (let j = 0; j < t.length; ++j) {
    if (!map.has(t[j])) return false
    map.set(t[j], map.get(t[j])-1)
    if (map.get(t[j]) === 0) map.delete(t[j])
  }
  return !map.size
}
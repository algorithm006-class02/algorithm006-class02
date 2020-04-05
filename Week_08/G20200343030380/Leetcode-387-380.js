/**
 * 387. First Unique Character in a String
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @param {string} s
 * @return {number}
 */
/*
const firstUniqChar = (s) => {
  for (let i = 0; i < s.length; ++i) {
    if (s.indexOf(s[i]) === s.lastIndexOf(s[i])) return i
  }
  return -1
}*/

const firstUniqChar = (s) => {
  let map = new Map()
  for (let i = 0; i < s.length; ++i) {
    map.set(s[i], map.has(s[i]) ? map.get(s[i]) + 1 : 1)
  }
  for (let i = 0; i < s.length; ++i) {
    if (map.get(s[i]) === 1) return i
  }
  return -1
}
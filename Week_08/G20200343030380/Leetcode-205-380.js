/**
 * 205. Isomorphic Strings
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
/**
 * 方法一：使用 String.indexOf 比较
 */
const isIsomorphic = (s, t) => {
  if (!s.length) return !t.length
  for (let i = 0; i < s.length; i++) {
    if (s.indexOf(s[i]) != t.indexOf(t[i])) return false
  }
  return true
}

/**
 * 方法二：使用两个 Map 比较
 */
const isIsomorphic = (s, t) => {
  if (!s.length) return !t.length
  let sMap = new Map(), tMap = new Map()
  for (let i = 0; i < s.length; i++) {
    if (sMap.get(s[i]) != tMap.get(t[i])) return false
    sMap.set(s[i], i)
    tMap.set(t[i], i)
  }
  return true
}
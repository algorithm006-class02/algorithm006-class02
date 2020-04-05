/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (!strs.length) return ''
  let str = ''
  let first = strs[0]
  let n = strs[0].length
  let i = 0
  while (i < n) {
    for (let s of strs) {
      if (s[i] != first[i]) return str
    }
    str += first[i]
    i++
  }
  return str
};
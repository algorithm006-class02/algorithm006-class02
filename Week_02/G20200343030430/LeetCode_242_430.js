/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
  if (s.length !== t.length) return false

  let arr = new Array(26).fill(0)
  for (let i = 0; i < s.length; i++) {
    arr[s[i].charCodeAt() - 97]++
    arr[t[i].charCodeAt() - 97]--
  }
  return !arr.some(v => !!v)
};

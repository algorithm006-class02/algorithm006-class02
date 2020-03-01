/**
 * @param {string} s
 * @return {boolean}
 */
var canPermutePalindrome = function (s) {
  let map = {}
  for (let i = 0; i < s.length; i++) {
    if (map[s[i]]) {
      map[s[i]]++
    } else {
      map[s[i]] = 1
    }
  }
  let arr = Object.values(map).filter(v => v % 2 !== 0)
  // console.log(arr)
  return arr.length <= 1
};

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  if (!digits || !digits.length) return []
  let arr = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
  let res = []
  search('', digits, 0, res, arr)
  return res
};

function search (str, digits, index, res, arr) {
  if (str.length === digits.length) {
    res.push(str)
    return
  }
  let letters = arr[digits[index]]
  for (let i = 0; i < letters.length; i++) {
    search(str + letters[i], digits, index + 1, res, arr)
  }
}
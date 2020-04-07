/**
 * 917. Reverse Only Letters
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * @param {string} S
 * @return {string}
 */
const reverseOnlyLetters = (S) => {
  if(S.length <= 1) return S
  let arr = S.split(''), len = arr.length, left = 0, right = len - 1
  while (left < right) {
    if (arr[left].match(/[^a-zA-Z]/)) { left++; continue }
    if (arr[right].match(/[^a-zA-Z]/)) { right--; continue }
    [arr[left++], arr[right--]] = [arr[right], arr[left]]
  }
  return arr.join('')
}
/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @param {string} digits
 * @return {string[]}
 */
const letterCombinations = (digits) => {
  let dict = {"2":"abc", "3":"def", "4":"ghi", "5":"jkl", "6":"mno", "7":"pqrs", "8":"tuv", "9":"wxyz"}
  let result = []
  backtrack(result, dict, digits, '', 0)
  return result
};

const backtrack = (result, dict, digits, tempStr, start) => {
  if (digits == "") return
  if (tempStr.length === digits.length) {
    result.push(tempStr)
    return
  }    
  for (let c of dict[digits[start]]) {
    backtrack(result, dict, digits, tempStr+c, start+1)
  }
}

letterCombinations("23")
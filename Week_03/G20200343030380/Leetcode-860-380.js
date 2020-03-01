/**
 * 860. Lemonade Change
 * https://leetcode.com/problems/lemonade-change/
 * @param {number[]} bills
 * @return {boolean}
 */
const lemonadeChange = (bills) => {
  let fiveNum = 0, tenNum = 0
  for(let i = 0; i < bills.length; i++) {
    if (bills[i] === 5) { fiveNum++; continue }
    if (bills[i] === 10) { fiveNum--; tenNum++ }
    if (bills[i] === 20) { tenNum ? (tenNum--, fiveNum--) : fiveNum -= 3 }
    if (fiveNum < 0) return false
  }
  return true
};


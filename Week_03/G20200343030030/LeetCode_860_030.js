/*
 * @lc app=leetcode.cn id=860 lang=javascript
 *
 * [860] 柠檬水找零
 */

// @lc code=start
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let count5 = 0;
    let count10 = 0;
    for (let i = 0; i < bills.length; i++) {
        if (bills[i] === 5) {
            count5++
        } else if (bills[i] === 10) {
            if (count5 > 0) {
                count5--;
            } else {
                return false
            }
            count10++;
        } else {
            if (count10 > 0) {
                count10--
                count5--
            } else {
                count5 -= 3
            }
        }
        if (count5 < 0) {
            return false
        }
    }
    return true;
};
// @lc code=end


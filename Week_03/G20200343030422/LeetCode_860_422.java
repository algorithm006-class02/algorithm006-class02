public class LeetCode_860_422 {

    /**
     * 柠檬水找零 (LeetCode#Q860 Easy)
     *
     * @param bills 账单列表
     * @return 如果你能给每位顾客正确找零，返回 true ，否则返回 false
     * @see <a href="https://leetcode-cn.com/problems/lemonade-change/">中文站</a>
     * @see <a href="https://leetcode.com/problems/lemonade-change/">英文站</a>
     */
    public boolean lemonadeChange(int[] bills) {
        //五元数量
        int five = 0;
        //十元数量
        int ten = 0;
        //没有账单，直接认为正确找零
        if (bills.length < 1) {
            return true;
        }
        //账单列表第一项不为5，认为无法找零
        if (bills[0] != 5) {
            return false;
        }
        //遍历账单
        for (int bill : bills) {
            //如果顾客支付了5美元，就得到一张5美元钞票
            if (bill == 5) {
                five++;
                //如果顾客支付了10美元，必需找回一张5美元钞票，如果没有5美元返回false，因为无法正确找零
            } else if (bill == 10) {
                if (five < 1) {
                    return false;
                }
                five--;
                ten++;
                //如果顾客支付20美元，必需找回一张10元一张5元 或 三张5元，如果无法给出面值为15美元的零钱返回false
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

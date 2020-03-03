package algorithm.leetCode.week03.No860;

/**
 * @author ltw
 * on 2020-03-03.
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean result = false;
        if (bills[0] != 5) {
            return false;
        }
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (((five - 1) < 0)) {
                    return false;
                } else {
                    --five;
                    ++ten;
                    result = true;
                }
            } else if (bills[i] == 20) {
                if (ten > 0 && five > 0) {
                    ten -= 1;
                    five -= 1;
                    result = true;
                } else if (five >= 3) { //仅five >0
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] x = {5, 5, 5, 20, 20, 10, 5, 10, 10, 20};
        System.out.println(solution.lemonadeChange(x));
    }
}

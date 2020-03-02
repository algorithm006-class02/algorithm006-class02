//860
//https://leetcode-cn.com/problems/lemonade-change

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int fives = 0, tens = 0, twenties = 0;
        for (int i = 0; i < bills.size(); i++) {
            if (5 == bills[i]) {
                fives++;
            } else if (10 == bills[i]) {
                tens++;
                if (fives >= 1) {
                    fives--;
                } else {
                    return false;
                }
            } else if (20 == bills[i]) {
                twenties++;
                if (tens >= 1 && fives >= 1) {
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
};

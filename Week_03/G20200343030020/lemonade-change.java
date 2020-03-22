class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bili : bills) {
            if (bili == 5) five++;
            else if (bili == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten++;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        if (bills.length < 1) return false;
        if (bills[0] != 5) return false;
        for (int index = 0; index < bills.length; ++index) {
            if (bills[index] == 5) five++;
            else if (bills[index] == 10) {
                if (five < 1) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) five -= 3;
                else return false;
            }
        }
        return true;
    }
}
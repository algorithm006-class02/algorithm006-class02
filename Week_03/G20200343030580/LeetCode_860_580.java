class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i : bills) {
            switch (i) {
                case 5:
                    five++;
                    break;
                case 10:
                    ten++;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    twenty++;
                    if (ten > 0) {
                        if (five > 0) {
                            ten--;
                            five--;
                        } else {
                            return false;
                        }
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}

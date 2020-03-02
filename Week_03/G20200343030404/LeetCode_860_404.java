class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        if(bills == null) {
            return false;
        }
        for(int bill : bills) {
            if(bill == 5) {
                five ++;
            } else if(bill == 10) {
                ten ++;
                five --;
            } else if(bill == 20) {
                ten --;
                five --;
            }

            if(ten < 0) {
                five += ten * 2;
                ten = 0;
            }
            if(five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }
}
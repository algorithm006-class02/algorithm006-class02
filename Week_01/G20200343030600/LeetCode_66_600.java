/**
 66.加一
    遍历digits，判断每位是否为9，若不是则+1并返回，否则将此位置0；
    对于digits里全为9的情况，需要扩展list，并将首位置为1。
 */

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}


class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] d = new int[digits.length + 1];
                    d[0] = 1;
                    System.arraycopy(digits, 0, d, 1, digits.length);
                    return d;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
}
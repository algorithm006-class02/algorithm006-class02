/**
 * 这是第一次写的代码，有点啰嗦
 */
class Solution {
    public int[] plusOne(int[] digits) {
        boolean first = true;
        boolean over = false;
        for (int i = digits.length - 1; i >= 0; i--){
            int r;
            if (first){
              r = digits[i] + 1;
              first = false;
            } else {
              r = digits[i];
            }

            if (over){
                r += 1;
            }

            if (r / 10 > 0){
                over = true;
            }else {
                over = false;
            }

            digits[i] = r % 10;
        }

        int[] result;
        if (over){
            result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
           return digits;
        }   
    }
}
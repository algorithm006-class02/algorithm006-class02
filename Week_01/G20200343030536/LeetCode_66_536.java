/**
 * @author : Hyuk
 * @description : LeetCode_66_536
 * @date : 2020/2/15 6:41 下午
 */
public class LeetCode_66_536 {

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            int val = digits[index] + 1;
            if (val != 10) {
                digits[index] = val;
                return digits;
            } else {
                digits[index] = 0;
            }
            index--;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}

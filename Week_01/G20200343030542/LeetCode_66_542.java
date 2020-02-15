public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
        }
        int[] array = new int[digits.length + 1];
        array[0] = 1;
        return array;
    }
}
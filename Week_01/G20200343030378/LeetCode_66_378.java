public class LeetCode_66_378 {
    public int[] plusOne(int[] digits) {
        if(null == digits)
            return null;
        int i = digits.length-1;
        while(i>=0){
            digits[i] = (++digits[i]) %10;
            if(digits[i]!=0)
                return digits;
            i--;
        }
        digits = new int[digits.length+1];
        digits[0] =1;
        return digits;
    }
}

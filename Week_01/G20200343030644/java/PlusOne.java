/**
 * 逆序遍历加一：如果不为0，直接返回；如果为0，则需要进位，再次往前遍历
 * 最后需要给数组扩容(+1)，且第一个元素为0
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len-1;
        while(i>=0){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i--]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return  digits;
    }
}

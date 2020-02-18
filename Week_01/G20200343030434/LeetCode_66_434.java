package algorithm.leetCode.geek.No66;

/**
 * @author ltw
 * on 2020-02-15.
 */
class Solution {
    //solution: 时间复杂度 O(n) 空间复杂度 O(n)
    // 错误解法： 错误原因 num 设置为 long 或 int 都不能满足题目要求
//    public int[] plusOne(int[] digits) {
//        long num = 0; //错误原因 :num 为long 和 int 都会溢出
//        for (int i = 0; i < digits.length; i++) {
//            num += digits[i] * Math.pow(10, (digits.length) - i - 1);
//        }
//        num++;
//        String numString = num + "";
//        int[] result = new int[numString.length()];
//        for (int i = 0; i < numString.length(); i++) {
//            result[i] = numString.charAt(i) - '0';
//        }
//        return result;
//    }

    //solution 时间复杂度 O(n) 空间复杂度 O(n)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {9, 9, 9};
        for (int x : solution.plusOne(test)) {
            System.out.println(x);
        }
    }
}

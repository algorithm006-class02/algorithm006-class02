/**
 * 题目：加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class LeetCode_66_022 {


    /**
     *最开始就是这种笨方法，把每个数都拿出来最后用++的方法，但后来发现LeetCode根本不让这种方法过，你是int他就给
     * 你一个超过你最大值的，你换成long也没用，所以还是要用后面的方法
     */
    public int[] plusOne(int[] digits) {
        long count = 0;
        for (int i = 0; i < digits.length; i++){
            count = count * 10 + digits[i];
        }
        count++;
        int[] res = new int[digits.length + 1];
        int last = res.length-1;
        int loopCount = 0;
        while( count != 0){
            res[last--] = (int)(count % 10);
            count = count / 10;
            loopCount++;
        }
        if(loopCount == digits.length){
            int[] res2 = new int[loopCount];
            System.arraycopy(res,1,res2,0,res2.length);
            return res2;
        }
        return res;
    }

    /**
     * 从第一种方法总结下来的经验就是直接在原数组进行加1
     * 如果取模后还是0 继续+1操作，反之直接返回
     * 如果一轮都+1了说明遇到了都是9的情况需要扩充一位
     */
    public int[] plusOne2(int[] digits) {
        for(int i = digits.length - 1; i >= 0;i--){
            digits[i] = digits[i] + 1;
            digits[i] %= 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        int[] res = new int[digits.length+1];
        System.arraycopy(digits,0,res,1,digits.length);
        res[0] = 1;
        return res;
    }


}
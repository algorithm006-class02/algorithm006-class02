package com.gsf.geekbang_demo.arithmetic.week01;

public class Work02 {

    public static void main(String[] args) {
        System.err.println(Day04.solution(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));;
    }

    public static int solution(int[] nums){
        int sum = 0;
        if (nums == null || nums.length < 3){
            return sum;
        }
        int len = nums.length;
        int one = nums[0];
        //下标数
        int id = 0;
        //跨越数
        int y = 0;
        //计算从左到右
        for (int i = 1; i < len; i++) {
            if (one <= nums[i]) {
                int x = i - id;
                if (x > 1){
                    sum += (x - 1) * nums[id] - y;
                }
                y = 0;
                one = nums[i];
                id = i;
            }else{
                y += nums[i];
            }
        }
        one = nums[len-1];
        id = len-1;
        y = 0;
        //计算从右到左
        for (int i = len-2; i >= 0; i--) {
            if (one < nums[i]) {
                int x = id - i;
                if (x > 1){
                    sum += (x - 1) * nums[id] - y;
                }
                y = 0;
                one = nums[i];
                id = i;
            }else{
                y += nums[i];
            }
        }
        return sum;
    }
}
